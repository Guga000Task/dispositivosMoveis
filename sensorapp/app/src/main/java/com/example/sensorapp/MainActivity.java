package com.example.sensorapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor lightSensor;
    private TextView textViewX, textViewY, textViewZ;
    private TextView textViewLight;
    private boolean isLightSensorActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewX = findViewById(R.id.textViewX);
        textViewY = findViewById(R.id.textViewY);
        textViewZ = findViewById(R.id.textViewZ);
        textViewLight = findViewById(R.id.textViewLight);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            textViewX.setText("Aceleração X: " + x);
            textViewY.setText("Aceleração Y: " + y);
            textViewZ.setText("Aceleração Z: " + z);

            if (x > 10 || y > 10 || z > 10) {
                if (!isLightSensorActive && lightSensor != null) {
                    sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
                    isLightSensorActive = true;

                    Toast.makeText(this, "Limite de aceleração atingido! Sensor de luz ativado.", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lightValue = event.values[0];
            textViewLight.setText("Luminosidade: " + lightValue + " lx");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
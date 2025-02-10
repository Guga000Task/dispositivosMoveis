package com.example.atictivades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = Double.parseDouble(editText2.getText().toString());
                double altura = Double.parseDouble(editText.getText().toString());

                Intent intent = new Intent(MainActivity.this, AtividadeB.class);
                intent.putExtra("PESO", peso);
                intent.putExtra("ALTURA", altura);
                startActivity(intent);
            }
        });
    }
}
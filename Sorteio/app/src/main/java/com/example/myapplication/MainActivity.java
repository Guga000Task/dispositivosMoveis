package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private Button buttonSortear;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonSortear = findViewById(R.id.buttonSortear);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonSortear.setOnClickListener(view -> {
            String strNum1 = editTextNumber1.getText().toString();
            String strNum2 = editTextNumber2.getText().toString();

            if (strNum1.isEmpty() || strNum2.isEmpty()) {
                textViewResultado.setText("Por favor, insira ambos os números.");
                return;
            }

            int num1 = Integer.parseInt(strNum1);
            int num2 = Integer.parseInt(strNum2);

            if (num1 > num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            Random random = new Random();
            int numeroSorteado = random.nextInt((num2 - num1) + 1) + num1;

            // Exibir o resultado
            textViewResultado.setText("Número sorteado: " + numeroSorteado);
        });
    }
}
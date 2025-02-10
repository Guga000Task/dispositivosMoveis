package com.example.atictivades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AtividadeB extends AppCompatActivity {

    private TextView textView;
    private TextView textIMC;

    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_b);

        textView = findViewById(R.id.textView);
        textIMC = findViewById(R.id.IMC);
        imagem = findViewById(R.id.imageView);

       Intent intent = getIntent();
       if (intent != null && intent.hasExtra("PESO") && intent.hasExtra("ALTURA")) {
           double peso = intent.getDoubleExtra("PESO", 0.0);
           double altura = intent.getDoubleExtra("ALTURA", 0.0);

           double imc = peso / (altura * altura);
           textView.setText("Seu IMC é: " + imc);

           if (imc < 18.5) {
               textIMC.setText("Classificação: Abaixo do peso");
               imagem.setImageResource(R.drawable.magro);
           } else if (imc < 24.9) {
               textIMC.setText("Classificação: Peso normal");
               imagem.setImageResource(R.drawable.normal);
           } else if (imc < 29.9) {
               textIMC.setText("Classificação: Sobrepeso");
               imagem.setImageResource(R.drawable.gordo);
           } else if (imc < 34.9) {
               textIMC.setText("Classificação: Obesidade Grau I");
               imagem.setImageResource(R.drawable.gordo);
           } else if (imc < 39.9) {
               textIMC.setText("Classificação: Obesidade Grau II");
               imagem.setImageResource(R.drawable.gordo);
           } else {
               textIMC.setText("Classificação: Obesidade Grau III");
               imagem.setImageResource(R.drawable.gordo);
           }
       }
    }
}
package com.example.sistemasolar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesPlanetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_planeta);

        // Referências aos views
        ImageView imageViewDetalhes = findViewById(R.id.imageViewDetalhes);
        TextView textViewNome = findViewById(R.id.textViewNome);
        TextView textViewDescricao = findViewById(R.id.textViewDescricao);

        // Receber os dados da Intent
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String descricao = intent.getStringExtra("descricao");
        int imagemResId = intent.getIntExtra("idImagem", R.drawable.ic_launcher_background); // Recupera o ID da imagem

        // Exibir os dados
        imageViewDetalhes.setImageResource(imagemResId); // Configura a imagem
        textViewNome.setText(nome);
        textViewDescricao.setText(descricao);
    }
}
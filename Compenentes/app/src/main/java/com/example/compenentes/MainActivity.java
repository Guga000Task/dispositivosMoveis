package com.example.compenentes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextEmail, editTextSenha;
    private RadioGroup radioGroupGenero;
    private CheckBox checkBoxTermos;
    private Button buttonEnviar;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar componentes
        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        radioGroupGenero = findViewById(R.id.radioGroupGenero);
        checkBoxTermos = findViewById(R.id.checkBoxTermos);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        progressBar = findViewById(R.id.progressBar);

        // Configurar clique do botão
        buttonEnviar.setOnClickListener(v -> enviarFormulario());
    }

    private void enviarFormulario() {
        // Exibir ProgressBar
        progressBar.setVisibility(View.VISIBLE);

        // Simular envio (delay de 2 segundos)
        buttonEnviar.postDelayed(() -> {
            progressBar.setVisibility(View.GONE);
            Snackbar.make(buttonEnviar, "Cadastro realizado com sucesso!", Snackbar.LENGTH_LONG).show();
        }, 2000);
    }
}
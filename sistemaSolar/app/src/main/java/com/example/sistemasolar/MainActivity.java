package com.example.sistemasolar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewPlanetas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Planeta> planetas = new ArrayList<>();
        planetas.add(new Planeta("Mercúrio", "Mercúrio é o planeta mais próximo do Sol.", R.drawable.mercurio));
        planetas.add(new Planeta("Vênus", "Vênus é conhecido como o planeta irmão da Terra.", R.drawable.venus));
        planetas.add(new Planeta("Terra", "Nosso planeta, o terceiro a partir do Sol.", R.drawable.terra));
        planetas.add(new Planeta("Marte", "Marte é conhecido como o Planeta Vermelho.", R.drawable.marte));
        planetas.add(new Planeta("Júpiter", "Júpiter é o maior planeta do sistema solar.", R.drawable.jupiter));
        planetas.add(new Planeta("Saturno", "Saturno é famoso por seus anéis.", R.drawable.saturno));
        planetas.add(new Planeta("Urano", "Urano é um gigante de gelo.", R.drawable.urano));
        planetas.add(new Planeta("Netuno", "Netuno é o planeta mais distante do Sol.", R.drawable.netuno));

        PlanetaAdapter adapter = new PlanetaAdapter(this, planetas);
        recyclerView.setAdapter(adapter);
    }
}

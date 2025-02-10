package com.example.sistemasolar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlanetaAdapter extends RecyclerView.Adapter<PlanetaAdapter.PlanetaViewHolder> {

    private Context context;
    private List<Planeta> planetas;

    public PlanetaAdapter(Context context, List<Planeta> planetas) {
        this.context = context;
        this.planetas = planetas;
    }

    @NonNull
    @Override
    public PlanetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_planeta, parent, false);
        return new PlanetaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetaViewHolder holder, int position) {
        Planeta planeta = planetas.get(position);

        // Configurar o nome do planeta
        holder.textViewNomePlaneta.setText(planeta.getNome());

        // Configurar a imagem do planeta
        holder.imagemView.setImageResource(planeta.getImagemResId());

        // Configurar o clique no item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalhesPlanetaActivity.class);
            intent.putExtra("nome", planeta.getNome());
            intent.putExtra("descricao", planeta.getDescricao());
            intent.putExtra("idImagem", planeta.getImagemResId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return planetas.size();
    }

    public static class PlanetaViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNomePlaneta;
        ImageView imagemView;

        public PlanetaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNomePlaneta = itemView.findViewById(R.id.textViewNomePlaneta);
            imagemView = itemView.findViewById(R.id.imageViewPlaneta);
        }
    }
}
package com.example.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerInterface;
import com.example.recyclerview.data.CountryCovidData;

import java.util.ArrayList;
import java.util.List;

public class CountryDataAdapter extends RecyclerView.Adapter<CountryDataAdapter.ViewHolder> {
    private RecyclerInterface recyclerInterface;
    private Context context;
    private List<CountryCovidData> dadosLista;

    public CountryDataAdapter(Context context, List<CountryCovidData> dadosLista, RecyclerInterface recyclerInterface) {
        this.recyclerInterface = recyclerInterface;
        this.context = context;
        this.dadosLista = dadosLista;
    }

    @NonNull
    @Override
    public CountryDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryDataAdapter.ViewHolder holder, int position) {
        CountryCovidData dados = dadosLista.get(position);
        holder.tvNomePais.setText(dados.getCountryText());
    }

    @Override
    public int getItemCount() {
        return dadosLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNomePais;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNomePais = itemView.findViewById(R.id.tvNomePais);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerInterface != null){
                        int posicao = getAdapterPosition();
                        CountryCovidData dados = dadosLista.get(posicao);
                        if (posicao != RecyclerView.NO_POSITION){
                            recyclerInterface.onItemClick(dados,posicao);
                        }
                    }
                }
            });
        }
    }
}

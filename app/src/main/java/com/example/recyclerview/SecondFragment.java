package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    TextView tvNomePais, tvCasosAtivos, tvCasosTotal, tvMortesTotal, tvNovosCasos, tvNovasMortes, tvRecuperadosTotal, tvDataAtualizacao;
    private CountryCovidData paisSelecionado;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        paisSelecionado = (CountryCovidData) getArguments().getSerializable("paisSelecionado");

        tvNomePais = binding.tvNomePaisSelecionado;
        tvCasosAtivos = binding.tvCasosAtivos;
        tvCasosTotal = binding.tvCasosTotal;
        tvMortesTotal = binding.tvMortesTotal;
        tvNovasMortes = binding.tvNovasMortes;
        tvNovosCasos = binding.tvNovosCasos;
        tvRecuperadosTotal = binding.tvRecuperadosTotal;
        tvDataAtualizacao = binding.tvDataAtualizacao;

        tvNomePais.setText(paisSelecionado.getCountryText());
        tvCasosAtivos.setText("Casos Ativos: " + paisSelecionado.getActiveCasesText());
        tvCasosTotal.setText("Total de Casos: " + paisSelecionado.getTotalCasesText());
        tvMortesTotal.setText("Total de Mortes: " + paisSelecionado.getTotalDeathsText());
        tvNovasMortes.setText("Novas Mortes: " + paisSelecionado.getNewDeathsText());
        tvNovosCasos.setText("Novos Casos: " + paisSelecionado.getNewCasesText());
        tvRecuperadosTotal.setText("Total de Recuperados: " + paisSelecionado.getTotalRecoveredText());
        tvDataAtualizacao.setText("Última Atualizaão: \n" + paisSelecionado.getLastUpdate());
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
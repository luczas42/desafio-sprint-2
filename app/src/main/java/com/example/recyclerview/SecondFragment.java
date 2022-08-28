package com.example.recyclerview;

import android.annotation.SuppressLint;
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

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        CountryCovidData paisSelecionado = pegaArgs();

        declaraCampos();

        checaCampos(paisSelecionado);

        return binding.getRoot();

    }

    private void declaraCampos() {
        tvNomePais = binding.tvNomePaisSelecionado;
        tvCasosAtivos = binding.tvCasosAtivos;
        tvCasosTotal = binding.tvCasosTotal;
        tvMortesTotal = binding.tvMortesTotal;
        tvNovasMortes = binding.tvNovasMortes;
        tvNovosCasos = binding.tvNovosCasos;
        tvRecuperadosTotal = binding.tvRecuperadosTotal;
        tvDataAtualizacao = binding.tvDataAtualizacao;
    }

    @SuppressLint("SetTextI18n")
    private void checaCampos(CountryCovidData paisSelecionado) {
        if (paisSelecionado.getCountryText() == null || paisSelecionado.getCountryText().equals("")) {
            tvNomePais.setText("");
        } else {
            tvNomePais.setText(paisSelecionado.getCountryText());
        }
        if (paisSelecionado.getActiveCasesText() == null || paisSelecionado.getActiveCasesText().equals("")) {
            tvCasosAtivos.setText("");
        } else {
            tvCasosAtivos.setText("Casos Ativos: " + paisSelecionado.getActiveCasesText());
        }
        if (paisSelecionado.getTotalCasesText() == null || paisSelecionado.getTotalCasesText().equals("")) {
            tvCasosTotal.setText("");
        } else {
            tvCasosTotal.setText("Total de Casos: " + paisSelecionado.getTotalCasesText());
        }
        if (paisSelecionado.getTotalDeathsText()== null || paisSelecionado.getTotalDeathsText().equals("")) {
            tvMortesTotal.setText("");
        } else {
            tvMortesTotal.setText("Total de Mortes: " + paisSelecionado.getTotalDeathsText());
        }
        if (paisSelecionado.getNewDeathsText() == null || paisSelecionado.getNewDeathsText().equals("")) {
            tvNovasMortes.setText("");
        } else {
            tvNovasMortes.setText("Novas Mortes: " + paisSelecionado.getNewDeathsText());
        }
        if (paisSelecionado.getNewCasesText() == null || paisSelecionado.getNewCasesText().equals("")) {
            tvNovosCasos.setText("");
        } else {
            tvNovosCasos.setText("Novos Casos: " + paisSelecionado.getNewCasesText());
        }
        if (paisSelecionado.getTotalRecoveredText()== null || paisSelecionado.getTotalRecoveredText().equals("")) {
            tvRecuperadosTotal.setText("");
        } else {
            tvRecuperadosTotal.setText("Total de Recuperados: " + paisSelecionado.getTotalRecoveredText());
        }
        if (paisSelecionado.getLastUpdate() == null || paisSelecionado.getLastUpdate().equals("")) {
            tvDataAtualizacao.setText("");
        } else {
            tvDataAtualizacao.setText("Última Atualizaão: \n" + paisSelecionado.getLastUpdate());
        }
    }

    private CountryCovidData pegaArgs() {
        assert getArguments() != null;
        return (CountryCovidData) getArguments().getSerializable("paisSelecionado");
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
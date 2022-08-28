package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapter.CountryDataAdapter;
import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.data.GetCovidDataListFromJson;
import com.example.recyclerview.databinding.FragmentFirstBinding;

import java.util.List;

public class FirstFragment extends Fragment implements RecyclerInterface {
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        List<CountryCovidData> dadosCovid = new GetCovidDataListFromJson().execute(requireContext().getApplicationContext());
        configuraRecyclerView(dadosCovid);
        return binding.getRoot();
    }

    private void configuraRecyclerView(List<CountryCovidData> dadosCovid) {
        RecyclerView recyclerViewCovid = binding.recyclerViewPaises;
        configuraAdapter(dadosCovid, recyclerViewCovid);
        configuraLayout(recyclerViewCovid);
    }

    private void configuraAdapter(List<CountryCovidData> dadosCovid, RecyclerView recyclerViewCovid) {
        CountryDataAdapter adapter = new CountryDataAdapter(getContext(), dadosCovid, this);
        recyclerViewCovid.setAdapter(adapter);
    }

    private void configuraLayout(RecyclerView recyclerViewCovid) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewCovid.setLayoutManager(layoutManager);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(CountryCovidData data) {
        Fragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("paisSelecionado", data);
        fragment.setArguments(bundle);
        vaiParaSecondFragment(bundle);
    }

    private void vaiParaSecondFragment(Bundle bundle) {
        NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
    }
}
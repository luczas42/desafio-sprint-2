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
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        RecyclerView recyclerViewCovid = binding.recyclerViewPaises;
        List<CountryCovidData> dadosCovid = new GetCovidDataListFromJson().execute(getContext().getApplicationContext());
        CountryDataAdapter adapter = new CountryDataAdapter(getContext(), dadosCovid, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewCovid.setLayoutManager(layoutManager);
        recyclerViewCovid.setAdapter(adapter);

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

    @Override
    public void onItemClick(CountryCovidData data, int posicao) {
        Fragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("paisSelecionado", data);
        fragment.setArguments(bundle);
        NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
    }
}
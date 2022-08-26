package com.example.recyclerview;

import com.example.recyclerview.data.CountryCovidData;

public interface RecyclerInterface {
    void onItemClick(CountryCovidData data, int posicao);
}

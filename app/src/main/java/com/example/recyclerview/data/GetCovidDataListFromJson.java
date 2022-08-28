package com.example.recyclerview.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GetCovidDataListFromJson implements GetCountryCovidDataListUseCase {

    public List<CountryCovidData> execute(Context appContext) {
        String filePath = "covid_all.json";
        String jsonFileString = JsonReader.jsonToString(appContext);
        String TAG = "Get Covida Data List";
        Log.i(TAG, jsonFileString);
        Gson gson = new Gson();
        Type dataType = new TypeToken<List<CountryCovidData>>() { }.getType();
        return gson.fromJson(jsonFileString, dataType);
    }
}

package com.example.mvc_java_based.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvc_java_based.R;
import com.example.mvc_java_based.adapter.CountriesAdapter;
import com.example.mvc_java_based.controller.CountriesController;
import com.example.mvc_java_based.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_countries;
    private CountriesAdapter countriesAdapter;
    private List<CountryModel> listCountryModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_countries = findViewById(R.id.rv_countries);
        listCountryModels = new ArrayList<>();

        /*countryModels = new ArrayList<>();
        countryModels.add(new CountryModel(123, "ABC", 123.0));
        countryModels.add(new CountryModel(123, "ABC", 123.0));
        countryModels.add(new CountryModel(123, "ABC", 123.0));
        countryModels.add(new CountryModel(123, "ABC", 123.0));
        countryModels.add(new CountryModel(123, "ABC", 123.0));*/

        new CountriesController(this);

        countriesAdapter = new CountriesAdapter(listCountryModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_countries.setLayoutManager(linearLayoutManager);
        rv_countries.setAdapter(countriesAdapter);

    }

    public void setDataCountryAdapter(List<CountryModel> cloudCountryModels) {
        listCountryModels.clear();
        listCountryModels.addAll(cloudCountryModels);
        countriesAdapter.notifyDataSetChanged();
    }

}
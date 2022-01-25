package com.example.mvc_java_based.controller;

import android.util.Log;

import com.example.mvc_java_based.MainActivity;
import com.example.mvc_java_based.model.CountriesService;
import com.example.mvc_java_based.model.CountryModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CountriesController {
    private MainActivity mainActivity;
    private CountriesService countriesService;

    public CountriesController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        countriesService = new CountriesService();
        fetchCountries();
    }

    private void fetchCountries() {
        countriesService.getCountryModel()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<CountryModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<CountryModel> countryModels) {
                        Log.d("Req onSuccess", ""+countryModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("Req onError", ""+e);
                    }
                });
    }
}

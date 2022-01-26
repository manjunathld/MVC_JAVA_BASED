package com.example.mvc_java_based.controller;

import android.util.Log;

import com.example.mvc_java_based.view.MainActivity;
import com.example.mvc_java_based.model.CountriesService;
import com.example.mvc_java_based.model.CountryModel;

import java.util.ArrayList;
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
                .subscribe(new DisposableSingleObserver<List<CountryModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<CountryModel> countryModels) {
                        for (int index = 0; index<countryModels.size(); index++) {
                            List<CountryModel> countryModelList = new ArrayList<CountryModel>(countryModels);
                            //Log.d("req_onSuccess", "ID: "+countryModelList.get(index).countryID);
                            Log.d("req_onSuccess", ""+countryModels);
                            mainActivity.setDataCountryAdapter(countryModels);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("req_onError", ""+e);
                    }
                });

    }
}

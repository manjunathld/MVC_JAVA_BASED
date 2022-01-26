package com.example.mvc_java_based.model;

import com.example.mvc_java_based.constants.Constants;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface CountriesAPI {
    @GET(Constants.PATH_COUNTRIES)
    Single<List<CountryModel>> getCountryModel();
}

package com.example.mvc_java_based.model;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface CountriesAPI {
    @GET("all")
    Single<List<CountryModel>> getCountryModel();
}

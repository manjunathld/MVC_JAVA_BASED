package com.example.mvc_java_based.model;

import com.google.gson.annotations.SerializedName;

public class CountryModel {
    @SerializedName("id")
    public int countryID;
    @SerializedName("market")
    public String countryMarketName;
    @SerializedName("price")
    public double countryPrice;

    /*public CountryModel (int countryID, String countryMarketName, double countryPrice) {
        this.countryID = countryID;
        this.countryMarketName = countryMarketName;
        this.countryPrice = countryPrice;
    }*/
}

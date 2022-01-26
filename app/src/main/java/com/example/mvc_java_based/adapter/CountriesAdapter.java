package com.example.mvc_java_based.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc_java_based.R;
import com.example.mvc_java_based.model.CountryModel;

import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {

    protected List<CountryModel> localListCountriesModel;

    public CountriesAdapter(List<CountryModel> countryModels) {
        localListCountriesModel = countryModels;
    }

     static class CountriesViewHolder extends RecyclerView.ViewHolder {
         TextView tv_countryID;
         TextView tv_countryMarketName;
         TextView tv_countryPrice;

         public CountriesViewHolder(View countryRowItemView) {
             super(countryRowItemView);
             tv_countryID = countryRowItemView.findViewById(R.id.tv_countryID);
             tv_countryMarketName = countryRowItemView.findViewById(R.id.tv_countryMarketName);
             tv_countryPrice = countryRowItemView.findViewById(R.id.tv_countryPrice);
         }

         public void bindData(CountryModel countryModel) {
             String countryID = Integer.toString(countryModel.countryID);
             String countryMarketName = countryModel.countryMarketName;
             String countryPrice = Double.toString(countryModel.countryPrice);
             tv_countryID.setText(countryID);
             tv_countryMarketName.setText(countryMarketName);
             tv_countryPrice.setText(countryPrice);
         }

    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View countryRowItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row_item, parent, false);
         return new CountriesViewHolder(countryRowItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        holder.bindData(localListCountriesModel.get(position));
    }

    @Override
    public int getItemCount() {
        return localListCountriesModel.size();
    }

}

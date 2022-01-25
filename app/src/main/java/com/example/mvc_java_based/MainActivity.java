package com.example.mvc_java_based;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mvc_java_based.controller.CountriesController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         new CountriesController(this);

    }
}
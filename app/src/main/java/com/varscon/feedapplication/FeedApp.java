package com.varscon.feedapplication;

import android.app.Application;

import com.varscon.feedapplication.DAOs.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FeedApp extends Application {
    private Retrofit retrofit;
    private static ApiInterface apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://private-8ce77c-tmobiletest.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);

    }

    public static ApiInterface getApiInterface() {return apiInterface;}
}

package com.varscon.feedapplication;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.varscon.feedapplication.DAOs.ApiInterface;
import com.varscon.feedapplication.Utils.RetrofitCached;

public class FeedApp extends Application {
    private static Context context;
    private static ApiInterface apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();

        FeedApp.context = getApplicationContext();
        apiInterface = RetrofitCached.getCacheEnabledRetrofit(context).create(ApiInterface.class);

    }

    public static Context getAppContext() {
        return FeedApp.context;
    }

    public static ApiInterface getApiInterface() {
        return apiInterface;
    }

    public static Boolean hasNetwork() {
        boolean isConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnected()) {
            isConnected = true;
        }
        return isConnected;
    }

}

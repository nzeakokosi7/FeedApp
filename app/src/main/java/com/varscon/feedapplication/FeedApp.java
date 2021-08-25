package com.varscon.feedapplication;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.varscon.feedapplication.DAOs.ApiInterface;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FeedApp extends Application {
    private static Context context;
    private static ApiInterface apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();

        FeedApp.context = getApplicationContext();
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-8ce77c-tmobiletest.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiInterface = retrofit.create(ApiInterface.class);

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

    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            if (hasNetwork()) {
                int maxAge = 60; // read from cache for 1 minute
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };

}

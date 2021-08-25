package com.varscon.feedapplication.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.varscon.feedapplication.FeedApp;
import com.varscon.feedapplication.Models.ApiResponse;
import com.varscon.feedapplication.Models.Card;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Card>> cardList;

    public LiveData<List<Card>> getFeeds() {
        cardList = new MutableLiveData<>();

        loadFeeds();

        return cardList;
    }

    private void loadFeeds() {
        Call<ApiResponse> call = FeedApp.getApiInterface().getFeeds();

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                Log.d("Response", response.toString());
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    cardList.setValue(response.body().getPage().getCards());
                } else {
                    Log.d("SSSS", response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("Err", t.getMessage());
            }
        });
    }
}
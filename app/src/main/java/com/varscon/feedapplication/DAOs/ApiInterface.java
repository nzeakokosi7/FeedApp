package com.varscon.feedapplication.DAOs;

import com.varscon.feedapplication.Models.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface ApiInterface {
    @Headers("Content-Type: application/json")
    @GET("test/home")
    Call<ApiResponse> getFeeds();

}

package com.example.test;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {


    @GET("3534")
    Call<montreal> getWeather();
}
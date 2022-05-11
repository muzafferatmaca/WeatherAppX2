package com.muzafferatmaca.weatherappx2.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Muzaffer Atmaca on 30.10.2020.
 */
public class RetrofitClient {

    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String KEY = "1f412081871814f334eb3543118e2aed";

    private static Retrofit retrofitClient = null;

    public static Retrofit getApi(){

        if (retrofitClient==null){
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofitClient;
    }
}

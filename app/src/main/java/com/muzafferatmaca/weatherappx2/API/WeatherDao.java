package com.muzafferatmaca.weatherappx2.API;

import com.muzafferatmaca.weatherappx2.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Muzaffer Atmaca on 30.10.2020.
 */
public interface WeatherDao {

    @GET("weather")
    Call<Example> getWeatherCity(@Query("q") String cityname,
                                 @Query("appid") String apikey);


}

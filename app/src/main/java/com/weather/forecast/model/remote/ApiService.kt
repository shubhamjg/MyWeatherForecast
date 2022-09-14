package com.weather.forecast.model.remote

import com.weather.forecast.model.remote.Constants.APPID
import com.weather.forecast.model.remote.Constants.UNITS
import com.weather.forecast.model.remote.data.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") appid: String = APPID,
        @Query("units") units: String = UNITS
    ): Response<WeatherResponse>
}
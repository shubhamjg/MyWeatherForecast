package com.weather.forecast.model.remote

import com.weather.forecast.model.remote.ApiService
import javax.inject.Inject

class ForecastRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getForecast(city: String) = apiService.getForecast(city)
}
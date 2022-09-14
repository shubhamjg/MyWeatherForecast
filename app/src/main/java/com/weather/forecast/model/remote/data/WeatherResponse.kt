package com.weather.forecast.model.remote.data

import com.weather.forecast.model.remote.data.City
import com.weather.forecast.model.remote.data.WeatherItem

data class WeatherResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: ArrayList<WeatherItem>,
    val message: Int
)
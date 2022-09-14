package com.weather.forecast.model.remote.data

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)
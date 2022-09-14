package com.weather.forecast.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.weather.forecast.databinding.ActivityWeatherBinding
import com.weather.forecast.view.Constants.DESCRIPTION
import com.weather.forecast.view.Constants.WEATHER

class WeatherActivity : AppCompatActivity() {
    lateinit var binding: ActivityWeatherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTemp.text = intent.getStringExtra(Constants.TEMP)
        binding.tvFeelTemp.text = "Feels like: " + intent.getStringExtra(Constants.FEELS_LIKE)
        binding.tvWeather.text = intent.getStringExtra(WEATHER)
        binding.tvDescription.text = intent.getStringExtra(DESCRIPTION)
    }
}
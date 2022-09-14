package com.weather.forecast.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.weather.forecast.databinding.ActivityWeatherListBinding
import com.weather.forecast.view.Constants.CITY
import com.weather.forecast.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherListActivity : AppCompatActivity() {
    lateinit var binding: ActivityWeatherListBinding
    lateinit var adapter: WeatherAdapter
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val city = intent.getStringExtra(CITY)
        city?.let {
            viewModel.getForecast(it)
        }
        viewModel.weatherResponseLiveData.observe(this) {
            adapter = WeatherAdapter(this, it.list)
            binding.rvWeather.layoutManager = LinearLayoutManager(this@WeatherListActivity)
            binding.rvWeather.adapter = adapter
        }

    }
}
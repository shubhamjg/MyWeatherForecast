package com.weather.forecast.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.weather.forecast.R
import com.weather.forecast.databinding.ViewWeatherBinding
import com.weather.forecast.model.remote.data.WeatherItem
import com.weather.forecast.view.Constants.DESCRIPTION
import com.weather.forecast.view.Constants.FEELS_LIKE
import com.weather.forecast.view.Constants.TEMP
import com.weather.forecast.view.Constants.WEATHER

class WeatherAdapter(val context: Context, private val weather: ArrayList<WeatherItem>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override fun getItemCount(): Int {
        return weather.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewWeatherBinding>(
            layoutInflater,
            R.layout.view_weather,
            parent,
            false
        )
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.setData(weather[position])
    }

    inner class WeatherViewHolder(private val binding: ViewWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(weather: WeatherItem) {
            binding.weather = weather
            binding.root.setOnClickListener {
                val intent = Intent(context, WeatherActivity::class.java)
                intent.putExtra(TEMP, weather.main.temp.toString())
                intent.putExtra(FEELS_LIKE, weather.main.feels_like.toString())
                intent.putExtra(WEATHER, weather.weather.get(0).main)
                intent.putExtra(DESCRIPTION, weather.weather.get(0).description)
                context.startActivity(intent)
            }
        }
    }
}
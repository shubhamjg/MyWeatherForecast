package com.weather.forecast.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.weather.forecast.databinding.ActivityMainBinding
import com.weather.forecast.view.Constants.CITY

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLookup.setOnClickListener {
            if (binding.etCity.text.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Please input city name.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(baseContext, WeatherListActivity::class.java)
                intent.putExtra(CITY, binding.etCity.text.toString())
                startActivity(intent)
            }
        }


    }
}
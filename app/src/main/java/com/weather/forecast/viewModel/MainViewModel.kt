package com.weather.forecast.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.forecast.model.remote.ForecastRepository
import com.weather.forecast.model.remote.data.WeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val forecastRepository: ForecastRepository) : ViewModel() {

    val weatherResponseLiveData = MutableLiveData<WeatherResponse>()

    fun getForecast(city: String) = viewModelScope.launch {

        val response = forecastRepository.getForecast(city)
        if (!response.isSuccessful) {
            return@launch
        }
        response.body()?.let {
            weatherResponseLiveData.postValue(it)
        }
    }
}
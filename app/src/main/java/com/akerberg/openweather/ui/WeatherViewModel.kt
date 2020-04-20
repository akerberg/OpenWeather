package com.akerberg.openweather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.akerberg.openweather.data.WeatherData
import com.akerberg.openweather.data.WeatherRepository

class WeatherViewModel constructor(
    //TODO Save state to avoid unnecessary reloading
    savedStateHandle: SavedStateHandle,
    cityId: Int,
    weatherRepository: WeatherRepository
) : ViewModel() {
    val weatherData: LiveData<WeatherData> =
        weatherRepository.fetchWeatherForCity(cityId.toString())
}
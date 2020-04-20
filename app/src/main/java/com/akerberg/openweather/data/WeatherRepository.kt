package com.akerberg.openweather.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.akerberg.openweather.api.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {

    private val api = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)

    //TODO Cache data to avoid unnecessary reading of data. Weather db is updated every 10 minutes.
    fun fetchWeatherForCity(cityId: String): LiveData<WeatherData> {
        val data = MutableLiveData<WeatherData>()
        api.fetchWeather(cityId, API_KEY)
            .enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                data.value = response.body()
            }
            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                //TODO Implement proper error handling
            }
        })
        return data
    }

    companion object {
        //TODO SET API_KEY otherwise it will not work
        private const val API_KEY = ""
        private const val URL = "https://api.openweathermap.org/"
    }
}
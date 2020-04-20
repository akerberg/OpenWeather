package com.akerberg.openweather.api

import com.akerberg.openweather.data.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/weather")
    fun fetchWeather(@Query(CITY_ID) cityId: String,
                     @Query(API_KEY) apiKey: String,
                     @Query(UNITS) units: String = UNIT_CELCIUS): Call<WeatherData>

    companion object {
        private const val CITY_ID = "id"
        private const val API_KEY = "APPID"
        private const val UNITS = "units"
        private const val UNIT_CELCIUS = "metric"
    }
}
package com.akerberg.openweather.data

data class WeatherData(
    val coord: Coord,
    val weather: Array<Weather>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Int,
    val sys: Sys,
    val id: Int,
    val name: String)

data class Coord(
    val lat: Float,
    val lon: Float
)

data class Wind(
    val speed: Float,
    val deg: Float)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String)

data class Sys(
    val type: Int,
    val id: Int,
    val message: Float,
    val country: String,
    val sunrise: Int,
    val sunset: Int
)

data class Main(
    val temp: Float,
    val pressure: Int,
    val humidity: Int,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float
)

data class Clouds(
    val all: Int)
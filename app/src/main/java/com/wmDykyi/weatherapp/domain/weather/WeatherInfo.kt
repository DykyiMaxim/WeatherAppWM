package com.wmDykyi.weatherapp.domain.weather

import com.wmDykyi.weatherapp.data.remote.WeatherDataDto

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)

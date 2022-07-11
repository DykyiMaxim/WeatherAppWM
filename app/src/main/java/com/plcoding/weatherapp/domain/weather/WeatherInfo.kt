package com.plcoding.weatherapp.domain.weather

import com.plcoding.weatherapp.data.remote.WeatherDataDto

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)

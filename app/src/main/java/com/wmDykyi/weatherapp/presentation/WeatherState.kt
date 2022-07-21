package com.wmDykyi.weatherapp.presentation

import com.wmDykyi.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo:WeatherInfo? = null,
    val isLoading:Boolean = false,
    val error:String? = null
)
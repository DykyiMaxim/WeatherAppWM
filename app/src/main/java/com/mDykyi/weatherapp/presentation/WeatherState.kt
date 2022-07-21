package com.mDykyi.weatherapp.presentation

import com.mDykyi.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo:WeatherInfo? = null,
    val isLoading:Boolean = false,
    val error:String? = null
)
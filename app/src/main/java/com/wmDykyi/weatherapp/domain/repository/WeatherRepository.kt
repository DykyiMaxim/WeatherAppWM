package com.wmDykyi.weatherapp.domain.repository

import com.wmDykyi.weatherapp.domain.util.Resource
import com.wmDykyi.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long:Double):Resource<WeatherInfo>
}
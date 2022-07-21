package com.mDykyi.weatherapp.domain.repository

import com.mDykyi.weatherapp.domain.util.Resource
import com.mDykyi.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long:Double):Resource<WeatherInfo>
}
package com.wmdykyi.weatherapp.domain.repository

import com.wmdykyi.weatherapp.domain.util.Resource
import com.wmdykyi.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long:Double):Resource<WeatherInfo>
}
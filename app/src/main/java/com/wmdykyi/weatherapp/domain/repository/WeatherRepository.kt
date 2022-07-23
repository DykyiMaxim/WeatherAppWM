package com.wmDykyi.weatherapp.domain.repository

import com.wmDykyi.weatherapp.domain.util.Resource
import com.wmDykyi.weatherapp.domain.weather.WeatherInfo
import java.time.LocalDate
import java.util.*

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long:Double, startD: LocalDate, endD: LocalDate): Resource<WeatherInfo>
}
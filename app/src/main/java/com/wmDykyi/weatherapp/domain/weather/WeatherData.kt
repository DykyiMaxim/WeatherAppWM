package com.wmDykyi.weatherapp.domain.weather

import java.time.LocalDateTime

data class WeatherData(
    val time:LocalDateTime,
    val temperatureCelsius:Double,
    val pressure:Double,
    val WindSpeed:Double,
    val humidity:Double,
    val WeatherType:WeatherType

)

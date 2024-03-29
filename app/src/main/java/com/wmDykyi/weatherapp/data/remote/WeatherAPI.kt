package com.wmDykyi.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDate
import java.util.*

interface WeatherAPI {
    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")

    suspend fun getWeatherData(
        @Query("latitude") lat:Double,
        @Query("longitude") long: Double,
        @Query("start_date") startD:LocalDate,
        @Query("end_date") endD:LocalDate
    ):WeatherDto
}
package com.wmDykyi.weatherapp.data.repository

import com.wmDykyi.weatherapp.data.mappers.toWeatherInfo
import com.wmDykyi.weatherapp.data.remote.WeatherAPI
import com.wmDykyi.weatherapp.domain.repository.WeatherRepository
import com.wmDykyi.weatherapp.domain.util.Resource
import com.wmDykyi.weatherapp.domain.weather.WeatherInfo
import java.lang.Exception
import java.time.LocalDate
import java.util.*
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor (

    private val api:WeatherAPI):WeatherRepository{

    override suspend fun getWeatherData(lat: Double, long: Double,startD:LocalDate,endD:LocalDate): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long,
                    startD = startD,
                    endD = endD
                ).toWeatherInfo()
            )

        }catch (e:Exception){
            e.printStackTrace()
            Resource.Error(e.message?:"An uncnown error")
        }
    }
}
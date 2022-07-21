package com.wmDykyi.weatherapp.data.repository

import com.wmDykyi.weatherapp.data.mappers.toWeatherInfo
import com.wmDykyi.weatherapp.data.remote.WeatherAPI
import com.wmDykyi.weatherapp.domain.repository.WeatherRepository
import com.wmDykyi.weatherapp.domain.util.Resource
import com.wmDykyi.weatherapp.domain.weather.WeatherInfo
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor (

    private val api:WeatherAPI):WeatherRepository{

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )

        }catch (e:Exception){
            e.printStackTrace()
            Resource.Error(e.message?:"An uncnown error")
        }
    }
}
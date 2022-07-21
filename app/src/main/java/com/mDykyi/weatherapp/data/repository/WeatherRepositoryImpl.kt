package com.mDykyi.weatherapp.data.repository

import com.mDykyi.weatherapp.data.mappers.toWeatherInfo
import com.mDykyi.weatherapp.data.remote.WeatherAPI
import com.mDykyi.weatherapp.domain.repository.WeatherRepository
import com.mDykyi.weatherapp.domain.util.Resource
import com.mDykyi.weatherapp.domain.weather.WeatherInfo
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
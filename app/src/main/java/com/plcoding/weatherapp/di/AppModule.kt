package com.plcoding.weatherapp.di
import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.plcoding.weatherapp.data.remote.WeatherAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherAPI {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okCl =OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okCl)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }
}
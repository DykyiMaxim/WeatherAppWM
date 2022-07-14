package com.plcoding.weatherapp.di

import com.plcoding.weatherapp.data.location.DefaultLocationTreacker
import com.plcoding.weatherapp.domain.location.LocationTreacker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {
    @Binds
    @Singleton
    abstract fun bindLocationTreaker(defaultLocationTreacker: DefaultLocationTreacker):LocationTreacker
}
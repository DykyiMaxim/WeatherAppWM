package com.mDykyi.weatherapp.di

import com.mDykyi.weatherapp.data.location.DefaultLocationTreacker
import com.mDykyi.weatherapp.domain.location.LocationTreacker
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
package com.wmDykyi.weatherapp.di
import com.wmDykyi.weatherapp.data.date.DefaultDatePick
import com.wmDykyi.weatherapp.domain.Date.DateInst
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DateModule{
    @Binds
    @Singleton
    abstract fun bindDateInst(defaultDatePick: DefaultDatePick): DateInst
}
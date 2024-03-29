package com.wmDykyi.weatherapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wmDykyi.weatherapp.data.date.DefaultDatePick
import com.wmDykyi.weatherapp.domain.Date.DateInst
import com.wmDykyi.weatherapp.domain.location.LocationTreacker
import com.wmDykyi.weatherapp.domain.repository.WeatherRepository
import com.wmDykyi.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository:WeatherRepository,
    private val locationTreacker: LocationTreacker,
    private val defaultDatePick: DateInst

):ViewModel() {

    var state by mutableStateOf(WeatherState())
    private set

    fun loadWeatherInfo(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTreacker.getCurrLocation()?.let{ location ->
                when(val result = repository.getWeatherData(location.latitude, location.longitude, startD =defaultDatePick.getToday(), endD =defaultDatePick.getTomorrow())){
                    is Resource.Success ->{
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error->{
                        state=  state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )

                    }

                }

            }?:kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Turn on location setting"
                )
            }


        }
    }
}
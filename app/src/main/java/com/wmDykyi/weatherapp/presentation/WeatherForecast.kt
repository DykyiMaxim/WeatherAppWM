package com.wmDykyi.weatherapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wmDykyi.weatherapp.R

@Composable
fun WeatherForecastToday(
    state:WeatherState,
    modifier: Modifier = Modifier
){
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let{ data->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.Today),
                color = Color.White

            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content ={
                items(data.subList(0,24)){wetherData->
                    HourlyWeatherData(
                        weatherData = wetherData,
                        modifier = Modifier
                            .width(100.dp)
                            .padding(horizontal = 10.dp)
                    )


                }
            } )

        }
        
    }
}
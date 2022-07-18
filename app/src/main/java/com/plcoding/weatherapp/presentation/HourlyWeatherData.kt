package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.plcoding.weatherapp.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

@Composable
fun HourlyWeatherData(
    weatherData: WeatherData,
    modifier: Modifier = Modifier

){
    val forecastedTime = remember(weatherData){
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = forecastedTime,
            color = Color.LightGray,
            //modifier = Modifier.padding(10.dp)
        )
        Image(
            painter = painterResource(id = weatherData.WeatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)

        )
        Text(text = "${weatherData.temperatureCelsius}℃",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            //modifier = Modifier.padding(10.dp)
        )

    }

}
package com.wmDykyi.weatherapp.presentation


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wmDykyi.weatherapp.R
import com.wmDykyi.weatherapp.presentation.ui.theme.CristalWhite
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt


@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor:androidx.compose.ui.graphics.Color,
    modifier: Modifier = Modifier
) {
    val context:Context = LocalContext.current


    state.weatherInfo?.currentWeatherData?.let { data ->
        val context:Context = LocalContext.current
        val stringDisc = data.WeatherType.weatherDesc.astoString(context)



        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = " ${stringResource(id = R.string.Today) +" "+ data.time.format(DateTimeFormatter.ofPattern("HH:mm"))
                }",
                    modifier = modifier.align(Alignment.End),
                    color = CristalWhite

                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id =data.WeatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text ="${data.temperatureCelsius}℃",
                    fontSize = 50.sp,
                    color = CristalWhite
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(text = stringDisc,
                    fontSize = 20.sp,
                    color = CristalWhite
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    WeatherDataDisplay(
                        value = data.pressure.roundToInt(),
                        unit = stringResource(id = R.string.hpa),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                        iconTint = CristalWhite


                    )

                    WeatherDataDisplay(
                        value = data.humidity.roundToInt(),
                        unit = stringResource(id = R.string.humidity),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        iconTint = CristalWhite,


                        )

                    WeatherDataDisplay(
                        value = data.WindSpeed.roundToInt(),
                        unit = stringResource(id = R.string.windsepeed),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        iconTint =CristalWhite,


                        )

                }

            }

        }
    }

}
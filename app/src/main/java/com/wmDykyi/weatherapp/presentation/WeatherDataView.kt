package com.wmDykyi.weatherapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun WeatherDataDisplay(
    value:Int,
    unit:String,
    icon:ImageVector,
    modifier: Modifier = Modifier,
    iconTint:androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.White

){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = modifier.size(25.dp)
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(text = "$value$unit",
            color = Color.White )

    }

}
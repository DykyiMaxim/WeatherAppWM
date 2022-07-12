package com.plcoding.weatherapp.domain.location

import android.location.Location

interface LocationTreacker {
    suspend fun getCurrLocation():Location?
}
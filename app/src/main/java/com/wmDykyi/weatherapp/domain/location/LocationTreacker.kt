package com.wmDykyi.weatherapp.domain.location

import android.location.Location

interface LocationTreacker {
    suspend fun getCurrLocation():Location?
}
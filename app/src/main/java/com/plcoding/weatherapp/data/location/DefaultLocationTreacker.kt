package com.plcoding.weatherapp.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.plcoding.weatherapp.domain.location.LocationTreacker
import javax.inject.Inject

class DefaultLocationTreacker @Inject constructor(
    private val LocationClient:FusedLocationProviderClient,
    private val application:Application
):LocationTreacker {
    override suspend fun getCurrLocation() {
        val hasAccesFineLocPremition = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

        val hasAccessCoarsLocationPremition = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        val Locationmanager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGPSEnabled = Locationmanager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                Locationmanager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }
}
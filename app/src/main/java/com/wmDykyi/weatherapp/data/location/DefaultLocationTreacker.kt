package com.wmDykyi.weatherapp.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.wmDykyi.weatherapp.domain.location.LocationTreacker
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class DefaultLocationTreacker @Inject constructor(
    private val LocationClient:FusedLocationProviderClient,
    private val application:Application
):LocationTreacker {
    override suspend fun getCurrLocation():Location? {
        val hasAccesFineLocPremition = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

        val hasAccessCoarsLocationPremition = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        val Locationmanager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGPSEnabled = Locationmanager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                Locationmanager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if(!hasAccessCoarsLocationPremition || !hasAccesFineLocPremition || !isGPSEnabled){
            Toast.makeText(application, "Please apply location permission ",Toast.LENGTH_LONG).show()
        }

        return suspendCancellableCoroutine { cont->
            LocationClient.lastLocation.apply {
                if (isComplete) {
                    if (isSuccessful) {
                        cont.resume(result)
                    }else{
                        cont.resume(null)

                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    cont.resume(it)
                }
                addOnFailureListener {
                    cont.resume(null)
                }
                addOnCanceledListener {
                    cont.cancel()
                }
            }
        }

    }
}
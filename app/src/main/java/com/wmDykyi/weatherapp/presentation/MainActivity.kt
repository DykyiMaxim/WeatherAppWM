package com.wmDykyi.weatherapp.presentation

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wmDykyi.weatherapp.presentation.ui.theme.DarkBlue
import com.wmDykyi.weatherapp.presentation.ui.theme.DeepBlue
import com.wmDykyi.weatherapp.presentation.ui.theme.WeatherWMTheme
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.logging.HttpLoggingInterceptor

@AndroidEntryPoint

class MainActivity : ComponentActivity() {

    private val viewModel:WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions() //already checked in location tracker
        ){
            viewModel.loadWeatherInfo()

        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,

        ))
        setContent {
            WeatherWMTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DarkBlue)
                ) {
                    WeatherCard(
                        state = viewModel.state,
                        backgroundColor = DeepBlue 
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    WeatherForecast(state = viewModel.state)

                }
                if(viewModel.state.isLoading){
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator()
                    }




                }
                viewModel.state.error?.let{ error->
                    Toast.makeText(this@MainActivity,error,Toast.LENGTH_LONG)

                }



                }

            }
        }
    }

package com.wmDykyi.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import com.wmDykyi.weatherapp.R
import com.wmDykyi.weatherapp.presentation.TextRes

sealed class WeatherType(
    val weatherDesc: TextRes,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.sunny, minName),
        iconRes = R.drawable.ic_sunny
    )
    object MainlyClear : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.MainlyClear, minName),
        iconRes = R.drawable.ic_cloudy
    )
    object PartlyCloudy : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.PartlyCloudy, minName),
        iconRes = R.drawable.ic_cloudy
    )
    object Overcast : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.Overcast, minName),
        iconRes = R.drawable.ic_cloudy
    )
    object Foggy : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.Foggy, minName),
        iconRes = R.drawable.ic_very_cloudy
    )
    object DepositingRimeFog : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.DepositingRimeFog, minName),
        iconRes = R.drawable.ic_very_cloudy
    )
    object LightDrizzle : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.LightDrizzle, minName),
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateDrizzle : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.ModerateDrizzle, minName),
        iconRes = R.drawable.ic_rainshower
    )
    object DenseDrizzle : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.DenseDrizzle, minName),
        iconRes = R.drawable.ic_rainshower
    )
    object LightFreezingDrizzle : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.LightDrizzle, minName),
        iconRes = R.drawable.ic_snowyrainy
    )
    object DenseFreezingDrizzle : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.DenseDrizzle, minName),
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightRain : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.SlghtRain, minName),
        iconRes = R.drawable.ic_rainy
    )
    object ModerateRain : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.ModerateRain, minName),
        iconRes = R.drawable.ic_rainy
    )
    object HeavyRain : WeatherType(
        weatherDesc = TextRes.StringRes(R.string.HeavyRain, minName),
        iconRes = R.drawable.ic_rainy
    )
    object HeavyFreezingRain: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.HeavyFreezingRain, minName),
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightSnowFall: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.SlightSnowFall, minName),
        iconRes = R.drawable.ic_snowy
    )
    object ModerateSnowFall: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.ModerateSnowFall, minName),
        iconRes = R.drawable.ic_heavysnow
    )
    object HeavySnowFall: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.HeavySnowFall, minName),
        iconRes = R.drawable.ic_heavysnow
    )
    object SnowGrains: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.SnowGrains, minName),
        iconRes = R.drawable.ic_heavysnow
    )
    object SlightRainShowers: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.SlightRainShowers, minName),
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateRainShowers: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.ModerateRainShowers, minName),
        iconRes = R.drawable.ic_rainshower
    )
    object ViolentRainShowers: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.ViolentRainShowers, minName),
        iconRes = R.drawable.ic_rainshower
    )
    object SlightSnowShowers: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.SlightSnowShowers, minName),
        iconRes = R.drawable.ic_snowy
    )
    object HeavySnowShowers: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.HeavySnowShowers, minName),
        iconRes = R.drawable.ic_snowy
    )
    object ModerateThunderstorm: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.ModerateThunderstorm, minName),
        iconRes = R.drawable.ic_thunder
    )
    object SlightHailThunderstorm: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.SlightHailThunderstorm, minName),
        iconRes = R.drawable.ic_rainythunder
    )
    object HeavyHailThunderstorm: WeatherType(
        weatherDesc = TextRes.StringRes(R.string.HeavyHailThunderstorm, minName),
        iconRes = R.drawable.ic_rainythunder
    )


    companion object {
        val minName =3
        fun fromWMO(code: Int): WeatherType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> MainlyClear
            }
        }
    }
}
package com.wmDykyi.weatherapp.domain.Date

import java.time.LocalDate

interface DateInst {
    suspend fun getToday(): LocalDate
    suspend fun getTomorrow():LocalDate
}
package com.wmDykyi.weatherapp.data.date

import com.wmDykyi.weatherapp.domain.Date.DateInst
import kotlinx.coroutines.suspendCancellableCoroutine
import java.time.LocalDate
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DefaultDatePick@Inject constructor():DateInst {
    override suspend fun getToday(): LocalDate {
        return  LocalDate.now() }





    override suspend fun getTomorrow(): LocalDate {
        return LocalDate.now().plusDays(1)}
        }





package com.plcoding.weatherapp.presentation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class TextRes {
     class StringRes(
         @androidx.annotation.StringRes val resId:Int,
         vararg val args:Any
     ): TextRes()
    
    @Composable
    fun asString():String{
        return when(this){
            is StringRes -> stringResource(resId, *args)
        }
    }

    fun astoString(context:Context):String{
        return when(this){
            is StringRes ->context.getString (resId, *args)
        }
    }
    
    
    
}
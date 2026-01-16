package com.example.csu_bulb.di

import android.content.Context
import com.example.csu_bulb.MyApplication

val Context.appComponent: AppComponent
    get() = when (applicationContext) {
        is MyApplication -> applicationContext.appComponent
        else -> (applicationContext as MyApplication).appComponent
    }

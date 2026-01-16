package com.example.csu_bulb

import android.app.Application
import com.example.csu_bulb.di.AppComponent
import com.example.csu_bulb.di.DaggerAppComponent


class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}
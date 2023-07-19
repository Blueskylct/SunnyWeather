package com.blueskylct.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application(){
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "1JFEEKM111G4joWK"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}
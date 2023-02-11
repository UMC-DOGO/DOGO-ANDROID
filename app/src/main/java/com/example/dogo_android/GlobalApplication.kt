package com.example.dogo_android

import android.app.Application

class GlobalApplication : Application() {

    companion object {
        lateinit var spf : MySharedPreference
    }

    override fun onCreate() {
        spf = MySharedPreference(applicationContext)
        super.onCreate()

    }
}
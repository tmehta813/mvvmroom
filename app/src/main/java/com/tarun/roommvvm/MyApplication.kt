package com.tarun.roommvvm

import android.app.Application

class MyApplication : Application() {

    companion object {
        private lateinit var appContext: Application
        fun getContext() = appContext.applicationContext
    }

    override fun onCreate() {
        appContext = this
        super.onCreate()
    }
}
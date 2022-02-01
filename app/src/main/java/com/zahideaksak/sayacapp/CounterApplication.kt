package com.zahideaksak.sayacapp

import android.app.Application
import timber.log.Timber

class CounterApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}
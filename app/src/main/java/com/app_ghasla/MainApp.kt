package com.app_ghasla

import android.app.Application
import com.app_ghasla.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApp)
            modules(AppModule.getModules())
        }
    }
}
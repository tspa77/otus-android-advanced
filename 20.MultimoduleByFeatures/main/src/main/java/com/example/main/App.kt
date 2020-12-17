package com.example.main

import android.app.Application
import com.example.main.di.AppComponent
import com.example.main.di.DaggerAppComponent
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class App : Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
            .builder()
            .build()
    }


    fun getComponent(): AppComponent {
        return component
    }
}

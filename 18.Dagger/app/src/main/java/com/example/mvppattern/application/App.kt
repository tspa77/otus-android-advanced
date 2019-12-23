package com.example.mvppattern.application

import android.app.Application
import com.example.mvppattern.di.component.AppComponent
import com.example.mvppattern.di.component.DaggerAppComponent

@kotlinx.serialization.UnstableDefault
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
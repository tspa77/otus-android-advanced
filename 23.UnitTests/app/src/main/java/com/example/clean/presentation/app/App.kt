package com.example.clean.presentation.app

import android.app.Application
import com.example.clean.di.component.AppComponent
import com.example.clean.di.component.DaggerAppComponent
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

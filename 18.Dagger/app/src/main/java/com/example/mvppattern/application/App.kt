package com.example.mvppattern.application

import android.app.Application
import com.example.mvppattern.di.component.AppComponent
import com.example.mvppattern.di.component.DaggerAppComponent
import com.example.mvppattern.di.module.AppModule

@kotlinx.serialization.UnstableDefault
class App : Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }


    fun getComponent(): AppComponent {
        return component
    }
}
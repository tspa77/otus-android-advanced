package com.example.mvppattern.application

import android.app.Application
import com.example.mvppattern.di.AppComponent
import com.example.mvppattern.di.DaggerAppComponent


class App : Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }

    fun getComponent(): AppComponent? {
        return component
    }
}
package com.example.mvppattern.application

import android.app.Application
import com.example.mvppattern.di.*


class App : Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
            .builder()
            .retrofitModule(RetrofitModule())
            .apiModule(ApiModule())
//            .repositoryModule(RepositoryModule())
            .build()
    }

    fun getComponent(): AppComponent? {
        return component
    }
}
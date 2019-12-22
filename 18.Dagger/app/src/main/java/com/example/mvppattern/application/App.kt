package com.example.mvppattern.application

import android.app.Application
import com.example.mvppattern.di.component.AppComponent
import com.example.mvppattern.di.component.DaggerAppComponent
import com.example.mvppattern.di.module.ApiModule
import com.example.mvppattern.di.module.RetrofitModule

@kotlinx.serialization.UnstableDefault
class App : Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
            .builder()
//            .retrofitModule(RetrofitModule())
//            .apiModule(ApiModule())
//            .repositoryModule(RepositoryModule())
            .build()
    }


    fun getComponent(): AppComponent? {
        return component
    }
}
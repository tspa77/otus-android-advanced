package com.example.mvppattern.di

import com.example.mvppattern.mvp.model.Repository
import dagger.Component

@kotlinx.serialization.UnstableDefault
@Component(modules = [RetrofitModule::class, ApiModule::class, RepositoryModule::class])
interface AppComponent {

    fun getRepository(): Repository
}

package com.example.mvppattern.di.component

import com.example.mvppattern.di.module.NetworkModule
import com.example.mvppattern.di.module.RepositoryModule
import com.example.mvppattern.mvp.model.Repository
import dagger.Component
import kotlinx.serialization.UnstableDefault
import javax.inject.Singleton

@UnstableDefault
@Singleton
@Component(
    modules = [RepositoryModule::class, NetworkModule::class]
)

interface AppComponent {

    fun repository(): Repository
}

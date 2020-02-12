package com.example.mvppattern.di.component

import com.example.network.NetworkModule
import com.example.network.RepositoryModule
import com.example.network.Repository
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

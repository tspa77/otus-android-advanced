package com.example.main.di

import com.example.network.di.NetworkModule
import com.example.network.di.RepositoryModule
import com.example.network.repository.Repository
import dagger.Component
import javax.inject.Singleton
import kotlinx.serialization.UnstableDefault

@UnstableDefault
@Singleton
@Component(
    modules = [RepositoryModule::class, NetworkModule::class]
)

interface AppComponent {

    fun repository(): Repository
}

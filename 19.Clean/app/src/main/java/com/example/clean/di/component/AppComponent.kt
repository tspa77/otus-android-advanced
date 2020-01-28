package com.example.clean.di.component

import com.example.clean.di.module.NetworkModule
import com.example.clean.di.module.RepositoryModule
import com.example.clean.data.repository.Repository
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

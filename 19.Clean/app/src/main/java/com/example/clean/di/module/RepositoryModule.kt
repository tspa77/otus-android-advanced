package com.example.clean.di.module

import com.example.clean.model.Repository
import com.example.clean.model.RepositoryImpl
import com.example.clean.model.network.NetworkProvider
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault
import javax.inject.Singleton

@UnstableDefault
@Module
object RepositoryModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideRepository(networkProvider: NetworkProvider): Repository =
        RepositoryImpl(networkProvider)
}

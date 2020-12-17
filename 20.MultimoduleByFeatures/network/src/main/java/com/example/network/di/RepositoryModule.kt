package com.example.network.di

import com.example.network.provider.NetworkProvider
import com.example.network.repository.Repository
import com.example.network.repository.RepositoryImpl
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

package com.example.network

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

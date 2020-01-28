package com.example.clean.di.module

import com.example.clean.data.repository.Repository
import com.example.clean.data.repository.RepositoryImpl
import com.example.clean.domain.provider.NetworkProvider
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault
import javax.inject.Singleton


@Module
object RepositoryModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideRepository(networkProvider: NetworkProvider): Repository =
        RepositoryImpl(networkProvider)
}

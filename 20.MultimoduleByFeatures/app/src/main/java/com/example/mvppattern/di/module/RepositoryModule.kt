package com.example.mvppattern.di.module

import com.example.mvppattern.model.Repository
import com.example.mvppattern.model.RepositoryImpl
import com.example.mvppattern.model.network.NetworkProvider
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

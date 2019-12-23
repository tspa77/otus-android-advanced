package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.model.RepositoryImpl
import com.example.mvppattern.mvp.model.network.NetworkProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@kotlinx.serialization.UnstableDefault
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(networkProvider: NetworkProvider): Repository {
        return RepositoryImpl(networkProvider)
    }
}

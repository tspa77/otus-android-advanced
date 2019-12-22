package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.model.network.Api
import com.example.mvppattern.mvp.model.network.CoroutineNetworkProvider
import com.example.mvppattern.mvp.model.network.NetworkProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@kotlinx.serialization.UnstableDefault
@Module
class NetworkProviderModule {

    @Provides
    @Singleton
    fun provideNetworkProvider(api: Api): NetworkProvider {
        return CoroutineNetworkProvider(api)
    }
}
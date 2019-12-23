package com.example.mvppattern.di.component

import com.example.mvppattern.di.module.*
import com.example.mvppattern.mvp.model.Repository
import dagger.Component
import javax.inject.Singleton

@kotlinx.serialization.UnstableDefault
@Singleton
@Component(
    modules = [AppModule::class, RetrofitModule::class, ApiModule::class, RepositoryModule::class,
        NetworkProviderModule::class]
)
interface AppComponent {

    fun getRepository(): Repository
}

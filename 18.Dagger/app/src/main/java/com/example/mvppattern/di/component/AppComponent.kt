package com.example.mvppattern.di.component

import com.example.mvppattern.di.module.ApiModule
import com.example.mvppattern.di.module.NetworkProviderModule
import com.example.mvppattern.di.module.RepositoryModule
import com.example.mvppattern.di.module.RetrofitModule
import com.example.mvppattern.mvp.model.Repository
import dagger.Component

@kotlinx.serialization.UnstableDefault
@Component(
    modules =
    [RetrofitModule::class, ApiModule::class, RepositoryModule::class,
        NetworkProviderModule::class]
)
interface AppComponent {

    //    fun inject(api: Api)
    fun getRepository(): Repository
}

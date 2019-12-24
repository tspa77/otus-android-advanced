package com.example.mvppattern.di.component

import com.example.mvppattern.di.module.NetworkModule
import com.example.mvppattern.di.module.RepositoryModule
import com.example.mvppattern.mvp.model.Repository
import dagger.Component
import javax.inject.Singleton

@kotlinx.serialization.UnstableDefault
@Singleton
@Component(
    modules = [RepositoryModule::class, NetworkModule::class]
)

interface AppComponent {

    fun repository(): Repository
    // read more about providing deps to child components from parent https://habr.com/ru/post/279641/
    // in our case child components are - cardMovieComponent & ListMovieComponent
    // also you can read about subcomponents in this article
}

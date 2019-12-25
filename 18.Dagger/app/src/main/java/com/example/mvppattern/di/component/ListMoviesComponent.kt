package com.example.mvppattern.di.component

import com.example.mvppattern.di.scope.ActivityScope
import com.example.mvppattern.di.module.ListMoviesModule
import com.example.mvppattern.mvp.view.ListMoviesViewActivity
import dagger.Component
import kotlinx.serialization.UnstableDefault

@UnstableDefault
@ActivityScope
@Component(
    modules = [ListMoviesModule::class],
    dependencies = [AppComponent::class]
)

interface ListMoviesComponent {

    fun inject(listMoviesViewActivity: ListMoviesViewActivity)
}

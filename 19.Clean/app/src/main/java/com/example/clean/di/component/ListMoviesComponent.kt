package com.example.clean.di.component

import com.example.clean.di.scope.ActivityScope
import com.example.clean.di.module.ListMoviesModule
import com.example.clean.ui.listmovies.ListMoviesViewActivity
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

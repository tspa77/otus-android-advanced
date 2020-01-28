package com.example.clean.di.component

import com.example.clean.di.scope.ActivityScope
import com.example.clean.di.module.ListMoviesModule
import com.example.clean.presentation.view.ListMoviesViewActivity
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

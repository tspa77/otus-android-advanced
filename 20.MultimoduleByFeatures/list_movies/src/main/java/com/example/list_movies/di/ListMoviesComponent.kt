package com.example.list_movies.di

import com.example.list_movies.view.ListMoviesViewActivity
import dagger.Component
import com.example.main.di.ActivityScope
import com.example.main.di.AppComponent
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

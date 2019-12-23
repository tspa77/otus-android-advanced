package com.example.mvppattern.di.component

import com.example.mvppattern.di.scope.ActivityScope
import com.example.mvppattern.di.module.ListMoviesPresenterModule
import com.example.mvppattern.di.module.ListMoviesViewModule
import com.example.mvppattern.mvp.view.ListMoviesViewActivity
import dagger.Component

@kotlinx.serialization.UnstableDefault
@ActivityScope
@Component(
    modules = [ListMoviesPresenterModule::class, ListMoviesViewModule::class],
    dependencies = [AppComponent::class]
)

interface ListMoviesComponent {

    fun inject(listMoviesViewActivity: ListMoviesViewActivity)
}

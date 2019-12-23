package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.view.ListMoviesView
import dagger.Module
import dagger.Provides

@kotlinx.serialization.UnstableDefault
@Module
class ListMoviesViewModule(private val activity: ListMoviesView) {

    @Provides
    fun provideListMoviesView(): ListMoviesView {
        return activity
    }
}

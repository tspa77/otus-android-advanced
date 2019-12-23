package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.presenter.ListMoviesPresenter
import com.example.mvppattern.mvp.presenter.ListMoviesPresenterImpl
import com.example.mvppattern.mvp.view.ListMoviesView
import dagger.Module
import dagger.Provides

@kotlinx.serialization.UnstableDefault
@Module
class ListMoviesPresenterModule {

    @Provides
    fun provideListMoviesPresenter(view: ListMoviesView, repository: Repository): ListMoviesPresenter {
        return ListMoviesPresenterImpl(view, repository)
    }
}
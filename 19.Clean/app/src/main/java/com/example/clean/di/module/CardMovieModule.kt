package com.example.clean.di.module

import com.example.clean.domain.repo.Repository
import com.example.clean.presentation.presenter.CardMoviePresenter
import com.example.clean.presentation.presenter.CardMoviePresenterImpl
import com.example.clean.presentation.view.CardMovieView
import dagger.Module
import dagger.Provides


@Module
class CardMovieModule(private val activity: CardMovieView) {

    @Provides
    fun provideCardMovieView(): CardMovieView = activity

    @Provides
    fun provideDetailsPresenter(view: CardMovieView, repository: Repository): CardMoviePresenter =
        CardMoviePresenterImpl(
            view,
            repository
        )
}

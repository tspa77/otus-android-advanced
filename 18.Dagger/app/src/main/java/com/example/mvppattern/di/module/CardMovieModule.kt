package com.example.mvppattern.di.module

import com.example.mvppattern.model.Repository
import com.example.mvppattern.ui.cardmovie.CardMoviePresenter
import com.example.mvppattern.ui.cardmovie.CardMoviePresenterImpl
import com.example.mvppattern.ui.cardmovie.CardMovieView
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault

@UnstableDefault
@Module
class CardMovieModule(private val activity: CardMovieView) {

    @Provides
    fun provideCardMovieView(): CardMovieView = activity

    @Provides
    fun provideDetailsPresenter(view: CardMovieView, repository: Repository): CardMoviePresenter =
        CardMoviePresenterImpl(view, repository)
}

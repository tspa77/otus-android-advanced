package com.example.clean.di.module

import com.example.clean.model.Repository
import com.example.clean.ui.cardmovie.CardMoviePresenter
import com.example.clean.ui.cardmovie.CardMoviePresenterImpl
import com.example.clean.ui.cardmovie.CardMovieView
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

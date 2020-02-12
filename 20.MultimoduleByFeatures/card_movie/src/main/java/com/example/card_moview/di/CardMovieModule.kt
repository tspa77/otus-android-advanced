package com.example.card_moview.di

import com.example.card_moview.presenter.CardMoviePresenter
import com.example.card_moview.presenter.CardMoviePresenterImpl
import com.example.card_moview.view.CardMovieView
import com.example.network.repository.Repository
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

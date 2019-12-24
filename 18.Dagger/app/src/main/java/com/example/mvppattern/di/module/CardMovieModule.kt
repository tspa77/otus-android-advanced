package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.presenter.CardMoviePresenter
import com.example.mvppattern.mvp.presenter.CardMoviePresenterImpl
import com.example.mvppattern.mvp.view.CardMovieView
import dagger.Module
import dagger.Provides

@kotlinx.serialization.UnstableDefault
@Module
class CardMovieModule(private val activity: CardMovieView) {

    @Provides
    fun provideCardMovieView(): CardMovieView {
        return activity
    }

    @Provides
    fun provideDetailsPresenter(view: CardMovieView, repository: Repository): CardMoviePresenter {
        return CardMoviePresenterImpl(view, repository)
    }
}

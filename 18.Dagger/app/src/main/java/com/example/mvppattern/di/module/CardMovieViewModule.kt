package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.view.CardMovieView
import dagger.Module
import dagger.Provides

@kotlinx.serialization.UnstableDefault
@Module
class CardMovieViewModule(private val activity: CardMovieView) {

    @Provides
    fun provideCardMovieView(): CardMovieView {
        return activity
    }
}

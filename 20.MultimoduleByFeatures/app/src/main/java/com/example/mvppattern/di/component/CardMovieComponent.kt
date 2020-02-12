package com.example.mvppattern.di.component

import com.example.mvppattern.di.module.CardMovieModule
import com.example.mvppattern.di.scope.ActivityScope
import com.example.mvppattern.ui.cardmovie.CardMovieViewActivity
import dagger.Component
import kotlinx.serialization.UnstableDefault

@UnstableDefault
@ActivityScope
@Component(
    modules = [CardMovieModule::class],
    dependencies = [AppComponent::class]
)

interface CardMovieComponent {

    fun inject(cardMovieViewActivity: CardMovieViewActivity)
}

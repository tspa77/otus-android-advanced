package com.example.card_moview.di

import com.example.card_moview.view.CardMovieViewActivity
import dagger.Component
import com.example.main.di.ActivityScope
import com.example.main.di.AppComponent
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

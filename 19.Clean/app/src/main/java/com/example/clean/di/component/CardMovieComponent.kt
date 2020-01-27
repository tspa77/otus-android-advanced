package com.example.clean.di.component

import com.example.clean.di.module.CardMovieModule
import com.example.clean.di.scope.ActivityScope
import com.example.clean.ui.cardmovie.CardMovieViewActivity
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

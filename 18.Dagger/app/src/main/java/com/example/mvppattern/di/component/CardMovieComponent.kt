package com.example.mvppattern.di.component

import com.example.mvppattern.di.scope.ActivityScope
import com.example.mvppattern.di.module.CardMoviePresenterModule
import com.example.mvppattern.di.module.CardMovieViewModule
import com.example.mvppattern.mvp.view.CardMovieViewActivity
import dagger.Component

@kotlinx.serialization.UnstableDefault
@ActivityScope
@Component(
    modules = [CardMovieViewModule::class, CardMoviePresenterModule::class],
    dependencies = [AppComponent::class]
)

interface CardMovieComponent {

    fun inject(cardMovieViewActivity: CardMovieViewActivity)
}

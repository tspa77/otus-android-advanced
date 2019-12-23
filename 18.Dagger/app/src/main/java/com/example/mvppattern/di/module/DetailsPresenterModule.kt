package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.presenter.DetailsPresenter
import com.example.mvppattern.mvp.presenter.DetailsPresenterImpl
import com.example.mvppattern.mvp.view.DetailsView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@kotlinx.serialization.UnstableDefault
@Module
class DetailsPresenterModule {

    @Provides
    inline fun provideDetailsPresenter(view: DetailsView, repository: Repository): DetailsPresenter {
        return DetailsPresenterImpl(view, repository)
    }
}
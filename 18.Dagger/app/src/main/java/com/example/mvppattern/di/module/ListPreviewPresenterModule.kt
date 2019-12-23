package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.presenter.ListPreviewPresenter
import com.example.mvppattern.mvp.presenter.ListPreviewPresenterImpl
import com.example.mvppattern.mvp.view.ListPreviewView
import dagger.Module
import dagger.Provides

@kotlinx.serialization.UnstableDefault
@Module
class ListPreviewPresenterModule {

    @Provides
    fun provideListPreviewPresenter(view: ListPreviewView, repository: Repository): ListPreviewPresenter {
        return ListPreviewPresenterImpl(view, repository)
    }
}
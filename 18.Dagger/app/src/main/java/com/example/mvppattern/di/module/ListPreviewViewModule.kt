package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.view.ListPreviewView
import dagger.Module
import dagger.Provides

@kotlinx.serialization.UnstableDefault
@Module
class ListPreviewViewModule(val activity: ListPreviewView) {

    @Provides
    fun provideListPreviewView(): ListPreviewView {
        return activity
    }
}

package com.example.mvppattern.di.module

import com.example.mvppattern.mvp.view.DetailsView
import dagger.Module
import dagger.Provides

@kotlinx.serialization.UnstableDefault
@Module
class DetailsViewModule(val activity: DetailsView) {

    @Provides
    inline fun provideDetailsView(): DetailsView {
        return activity
    }
}

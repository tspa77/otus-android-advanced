package com.example.mvppattern.di.component

import com.example.mvppattern.di.ActivityScope
import com.example.mvppattern.di.module.ListPreviewPresenterModule
import com.example.mvppattern.di.module.ListPreviewViewModule
import com.example.mvppattern.mvp.view.ListPreviewViewActivity
import dagger.Component

@kotlinx.serialization.UnstableDefault
@ActivityScope
@Component(
    modules = [ListPreviewPresenterModule::class, ListPreviewViewModule::class],
    dependencies = [AppComponent::class]
)

interface ListPreviewComponent {

    fun inject(listPreviewViewActivity: ListPreviewViewActivity)
}

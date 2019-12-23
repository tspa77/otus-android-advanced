package com.example.mvppattern.di.component

import com.example.mvppattern.di.ActivityScope
import com.example.mvppattern.di.module.DetailsPresenterModule
import com.example.mvppattern.di.module.DetailsViewModule
import com.example.mvppattern.mvp.view.DetailsViewActivity
import dagger.Component

@kotlinx.serialization.UnstableDefault
@ActivityScope
@Component(
    modules = [DetailsViewModule::class, DetailsPresenterModule::class],
    dependencies = [AppComponent::class]
)
interface DetailsViewComponent {

    fun inject(detailsViewActivity: DetailsViewActivity)
}

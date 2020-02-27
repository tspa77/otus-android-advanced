package com.example.clean.presentation.view

import android.view.LayoutInflater
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric.buildActivity
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BaseLoadingViewActivityTest {

    lateinit var baseLoadingViewActivity: BaseLoadingViewActivity

    @Test
    fun showLoading() {
    }

    @Test
    fun hideLoading() {
    }

    @Test
    fun showError() {
//        val activity = buildActivity(BaseLoadingViewActivity::class.java).setup().get()
//        baseLoadingViewActivity = LayoutInflater.from(activity).inflate()
    }
}
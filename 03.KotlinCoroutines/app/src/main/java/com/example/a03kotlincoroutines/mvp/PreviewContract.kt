package com.example.a03kotlincoroutines.mvp

import com.example.a03kotlincoroutines.mvp.model.MoviePreview
import com.example.a03kotlincoroutines.mvp.presenter.BasePresenter
import com.example.a03kotlincoroutines.mvp.view.BaseView

interface PreviewContract {

    interface ListPreviewsView<PresenterListPreviews> : BaseView {
        fun showListPreviews(listPreviews: List<MoviePreview>)
    }

    interface ListPreviewsPresenter : BasePresenter {
        fun loadListPreviews()
    }
}

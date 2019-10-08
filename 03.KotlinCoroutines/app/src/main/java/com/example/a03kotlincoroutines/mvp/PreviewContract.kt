package com.example.a03kotlincoroutines.mvp

import com.example.a03kotlincoroutines.mvp.model.MoviePreview
import com.example.a03kotlincoroutines.mvp.presenter.PresenterBase
import com.example.a03kotlincoroutines.mvp.view.BaseView

interface PreviewContract {

    interface ViewList<PresenterListPreviews> : BaseView {
        fun showListPreviews(listPreviews: List<MoviePreview>)
    }

    interface PresenterListPreviews : PresenterBase {
        fun loadListPreviews()
    }
}

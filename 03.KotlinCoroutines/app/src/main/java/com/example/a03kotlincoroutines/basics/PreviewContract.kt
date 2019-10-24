package com.example.a03kotlincoroutines.basics

import com.example.a03kotlincoroutines.model.MoviePreview

interface PreviewContract {

    interface ListPreviewsView<PresenterListPreviews> :
        BaseView {
        fun showListPreviews(listPreviews: List<MoviePreview>)
    }

    interface ListPreviewsPresenter : BasePresenter {
        fun loadListPreviews()
    }
}

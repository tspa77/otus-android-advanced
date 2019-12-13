package com.example.mvppattern.basics

import com.example.mvppattern.model.MoviePreview

interface PreviewContract {

    interface ListPreviewsView<PresenterListPreviews> :
        BaseView {
        fun showListPreviews(listPreviews: List<MoviePreview>)
    }

    interface ListPreviewsPresenter : BasePresenter {
        fun loadListPreviews()
    }
}

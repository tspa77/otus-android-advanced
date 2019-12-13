package com.example.mvppattern.contracts

import com.example.mvppattern.data.MoviePreview
import com.example.mvppattern.mvp.presenter.BasePresenter
import com.example.mvppattern.mvp.view.BaseView

interface PreviewContract {

    interface ListPreviewsView<PresenterListPreviews> :
        BaseView {
        fun showListPreviews(listPreviews: List<MoviePreview>)
    }

    interface ListPreviewsPresenter :
        BasePresenter {
        fun loadListPreviews()
    }
}

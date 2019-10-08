package com.example.a03kotlincoroutines.mvp

import com.example.a03kotlincoroutines.mvp.model.MovieDetails
import com.example.a03kotlincoroutines.mvp.presenter.BasePresenter
import com.example.a03kotlincoroutines.mvp.view.BaseView

interface DetailsContract {

    interface BaseViewInfo<PresenterDetails> : BaseView {
        fun showDetailsInfo(movieInfo: MovieDetails)
    }

    interface DetailsPresenter : BasePresenter {
        fun loadDetailsInfo(id: Int)
    }
}

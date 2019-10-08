package com.example.a03kotlincoroutines.mvp

import com.example.a03kotlincoroutines.mvp.model.MovieDetails
import com.example.a03kotlincoroutines.mvp.presenter.PresenterBase
import com.example.a03kotlincoroutines.mvp.view.BaseView

interface DetailsContract {

    interface ViewInfo<PresenterDetails> : BaseView {
        fun showDetailsInfo(movieInfo: MovieDetails)
    }

    interface PresenterDetails : PresenterBase {
        fun loadDetailsInfo(id: Int)
    }
}

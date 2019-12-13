package com.example.mvppattern.contracts

import com.example.mvppattern.data.MovieDetails
import com.example.mvppattern.mvp.presenter.BasePresenter
import com.example.mvppattern.mvp.view.BaseView

interface DetailsContract {

    interface BaseViewInfo<PresenterDetails> :
        BaseView {
        fun showDetailsInfo(movieInfo: MovieDetails)
    }

    interface DetailsPresenter :
        BasePresenter {
        fun loadDetailsInfo(id: Int)
    }
}

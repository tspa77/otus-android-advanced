package com.example.a03kotlincoroutines.mvp

import com.example.a03kotlincoroutines.mvp.model.Movie
import com.example.a03kotlincoroutines.mvp.presenter.BasePresenter
import com.example.a03kotlincoroutines.mvp.view.BaseView

interface MovieContract {
    interface View : BaseView<Presenter> {
       fun updateListMovies(loadMovies: List<Movie>)
    }

    interface Presenter : BasePresenter {
        fun loadListMovies()
        fun loadMovie()
    }


}
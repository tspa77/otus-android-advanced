package com.example.mvppattern.di.module

import android.content.Context
import com.example.mvppattern.adapter.MovieAdapter
import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.presenter.ListMoviesPresenter
import com.example.mvppattern.mvp.presenter.ListMoviesPresenterImpl
import com.example.mvppattern.mvp.view.ListMoviesView
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault

@UnstableDefault
@Module
class ListMoviesModule(private val activity: ListMoviesView) {

    @Provides
    fun provideListMoviesView(): ListMoviesView {
        return activity
    }

    @Provides
    fun provideListMoviesPresenter(
        view: ListMoviesView,
        repository: Repository
    ): ListMoviesPresenter {
        return ListMoviesPresenterImpl(view, repository)
    }

    @Provides
    fun provideMovieAdapter(
        context: Context, onItemClickListener: MovieAdapter.OnItemClickListener
    ): MovieAdapter {
        return MovieAdapter(context, onItemClickListener)
    }

    @Provides
    fun provideContext(): Context = activity as Context

    @Provides
    fun provideOnItemClickListener(): MovieAdapter.OnItemClickListener =
        activity as MovieAdapter.OnItemClickListener


}

package com.example.mvppattern.di.module

import android.content.Context
import com.example.mvppattern.ui.listmovies.adapter.MovieAdapter
import com.example.mvppattern.model.Repository
import com.example.mvppattern.ui.listmovies.ListMoviesPresenter
import com.example.mvppattern.ui.listmovies.ListMoviesPresenterImpl
import com.example.mvppattern.ui.listmovies.ListMoviesView
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault

@UnstableDefault
@Module
class ListMoviesModule(private val activity: ListMoviesView) {

    @Provides
    fun provideListMoviesView(): ListMoviesView = activity

    @Provides
    fun provideListMoviesPresenter(
        view: ListMoviesView, repository: Repository
    ): ListMoviesPresenter =
        ListMoviesPresenterImpl(
            view,
            repository
        )

    @Provides
    fun provideMovieAdapter(
        context: Context, onItemClickListener: MovieAdapter.OnItemClickListener
    ): MovieAdapter = MovieAdapter(context, onItemClickListener)

    @Provides
    fun provideContext(): Context = activity as Context

    @Provides
    fun provideOnItemClickListener(): MovieAdapter.OnItemClickListener =
        activity as MovieAdapter.OnItemClickListener
}

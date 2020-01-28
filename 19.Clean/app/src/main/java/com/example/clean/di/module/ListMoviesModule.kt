package com.example.clean.di.module

import android.content.Context
import com.example.clean.data.repository.Repository
import com.example.clean.presentation.presenter.ListMoviesPresenter
import com.example.clean.presentation.presenter.ListMoviesPresenterImpl
import com.example.clean.presentation.view.ListMoviesView
import com.example.clean.presentation.view.adapter.MovieAdapter
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

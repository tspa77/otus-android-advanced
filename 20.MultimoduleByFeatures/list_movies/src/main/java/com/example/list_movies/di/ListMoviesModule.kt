package com.example.list_movies.di

import android.content.Context
import com.example.network.repository.Repository
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault

@UnstableDefault
@Module
class ListMoviesModule(private val activity: com.example.list_movies.view.ListMoviesView) {

    @Provides
    fun provideListMoviesView(): com.example.list_movies.view.ListMoviesView = activity

    @Provides
    fun provideListMoviesPresenter(
        view: com.example.list_movies.view.ListMoviesView, repository: Repository
    ): com.example.list_movies.presenter.ListMoviesPresenter =
        com.example.list_movies.presenter.ListMoviesPresenterImpl(
            view,
            repository
        )

    @Provides
    fun provideMovieAdapter(
        context: Context,
        onItemClickListener: com.example.list_movies.adapter.MovieAdapter.OnItemClickListener
    ): com.example.list_movies.adapter.MovieAdapter =
        com.example.list_movies.adapter.MovieAdapter(
            context,
            onItemClickListener
        )

    @Provides
    fun provideContext(): Context = activity as Context

    @Provides
    fun provideOnItemClickListener(): com.example.list_movies.adapter.MovieAdapter.OnItemClickListener =
        activity as com.example.list_movies.adapter.MovieAdapter.OnItemClickListener
}

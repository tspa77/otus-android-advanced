package com.example.clean.data.repository

import android.util.Log
import com.example.clean.domain.AppConstants.TMDB_LOG_TAG
import com.example.clean.domain.dto.MovieInfo
import com.example.clean.domain.dto.MoviePreview
import com.example.clean.domain.provider.NetworkProvider


class RepositoryImpl (private val networkProvider: NetworkProvider) :
    Repository {

    // На данный момент это лишь имитация репозитория, для создания каноничной модели,
    // просто проксирует запросы к сети, кэширование и локальная БД просто подразумеваются

    override fun getListMoviePreviews(
        onDone: (List<MoviePreview>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        networkProvider.requestListMoviePreviews({
            onDone(it)
            Log.d(TMDB_LOG_TAG, "Repository\n" + it.joinToString("\n"))
        }, {
            onError(it)
            Log.d(TMDB_LOG_TAG, "Repository\n" + it.stackTrace.joinToString("\n"))
        })
    }

    override fun getMovieInfo(
        id: Int,
        onDone: (MovieInfo) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        networkProvider.requestMovieInfo(id, {
            onDone(it)
            Log.d(TMDB_LOG_TAG, it.toString())
        }, {
            onError(it)
            Log.d(TMDB_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}

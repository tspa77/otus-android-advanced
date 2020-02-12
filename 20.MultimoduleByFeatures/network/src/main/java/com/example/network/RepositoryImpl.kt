package com.example.network

import android.util.Log
import com.example.core.AppConstants.TMDB_LOG_TAG
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class RepositoryImpl (private val networkProvider: NetworkProvider) :
    Repository {

    // На данный момент это лишь имитация репозитория, просто проксирует запросы к сети
    // В текущей реализации можно из презентера напрямую обращаться к нетворкпровайдеру.
    // Пока он здесь для создания каноничной модели, но при необходимости, здесь при
    // ошибке сети реализую обращение к кэшированным данным

    override fun getListMoviePreviews(
        onDone: (List<com.example.core.dto.MoviePreview>) -> Unit,
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
        onDone: (com.example.core.dto.MovieInfo) -> Unit,
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

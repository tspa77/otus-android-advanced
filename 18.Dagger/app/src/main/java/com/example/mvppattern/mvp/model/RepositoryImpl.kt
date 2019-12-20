package com.example.mvppattern.mvp.model

import android.util.Log
import com.example.mvppattern.application.AppConstants.MY_LOG_TAG
import com.example.mvppattern.mvp.model.network.CoroutineNetworkProvider

@kotlinx.serialization.UnstableDefault
object RepositoryImpl : Repository {

    private val networkProvider = CoroutineNetworkProvider

    // На данный момент это лишь имитация репозитория, просто проксирует запросы к сети
    // В текущей реализации можно из презентера напрямую обращаться к нетворкпровайдеру.
    // ПОка он здесь для создания каноничной модели, но при необходимости, здесь при
    // ошибке сети реализую обращение к кэшированным данным

    override fun getListPreviews(
        onDone: (List<MoviePreview>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        networkProvider.downloadListPreviews({
            onDone(it)
            Log.d(MY_LOG_TAG, "Repository\n" + it.joinToString("\n"))
        }, {
            onError(it)
            Log.d(MY_LOG_TAG, "Repository\n" + it.stackTrace.joinToString("\n"))
        })
    }

    override fun getDetailsInfo(
        id: Int,
        onDone: (MovieDetails) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        networkProvider.downloadDetailsInfo(id, {
            onDone(it)
            Log.d(MY_LOG_TAG, it.toString())
        }, {
            onError(it)
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}

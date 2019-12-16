package com.example.mvppattern.mvp.model

import android.util.Log
import com.example.mvppattern.AppConstants.MY_LOG_TAG
import com.example.mvppattern.adapter.MovieDetails
import com.example.mvppattern.adapter.MoviePreview
import com.example.mvppattern.network.CoroutineNetworkProvider

@kotlinx.serialization.UnstableDefault
object RepositoryImpl : Repository {

    private val networkProvider = CoroutineNetworkProvider

    //TODO onError: вместо ошибок подгружать кэишрованные локально данные

    override fun getListPreviews(
        onDone: (List<MoviePreview>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        networkProvider.downloadListPreviews({
            Log.d(MY_LOG_TAG, "Repository\n" + it.joinToString("\n"))


        }, {
            Log.d(MY_LOG_TAG, "Repository\n" + it.stackTrace.joinToString("\n"))
        })
    }

    override fun getDetailsInfo(
        id: Int,
        onDone: (MovieDetails) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        networkProvider.downloadDetailsInfo(id, {
            Log.d(MY_LOG_TAG, it.toString())
        }, {
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
        })

    }
}

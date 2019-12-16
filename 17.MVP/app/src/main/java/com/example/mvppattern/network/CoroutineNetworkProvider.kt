package com.example.mvppattern.network

import com.example.mvppattern.adapter.MovieDetails
import com.example.mvppattern.adapter.MoviePreview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CoroutineNetworkProvider : NetworkProvider {

    @kotlinx.serialization.UnstableDefault
    private val api = RetrofitFactory.getMovieService()

    @kotlinx.serialization.UnstableDefault
    override fun downloadListPreviews(
        onDone: (List<MoviePreview>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                onDone(api.getListPopularMovies().results)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    @kotlinx.serialization.UnstableDefault
    override fun downloadDetailsInfo(
        id: Int,
        onDone: (MovieDetails) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                onDone(api.getMovie(id))
            } catch (e: java.lang.Exception) {
                onError(e)
            }
        }
    }
}

package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.mvp.model.MovieFullInfo
import com.example.a03kotlincoroutines.mvp.model.MoviePreview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CoroutineNetworkProvider : NetworkProvider {


    private val api = RetrofitFactory.getMovieService()

    override fun getListMovies(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                onDone(api.getListPopularMovies().results)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }


    override fun getDetailMovie(
        id: Int,
        onDone: (MovieFullInfo) -> Unit,
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

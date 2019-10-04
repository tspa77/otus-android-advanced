package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.mvp.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CoroutineNetworkProvider:NetworkProvider {

    private val api = RetrofitFactory.getMovieService()

    override fun getListMovies(onDone: (List<Movie>) -> Unit, onError: (Throwable) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                onDone(api.getListPopularMovies().results)
            } catch (e: Exception) {
                onError(e)
            }
        }

    }

    override fun getDetailMovie(
        tag: String,
        onDone: (Movie) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
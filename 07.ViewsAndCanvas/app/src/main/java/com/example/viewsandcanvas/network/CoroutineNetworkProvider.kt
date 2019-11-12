package com.example.viewsandcanvas.network

import com.example.viewsandcanvas.model.MovieDetails
import com.example.viewsandcanvas.model.MoviePreview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CoroutineNetworkProvider : NetworkProvider {

    private val api = RetrofitFactory.getMovieService()

    override fun getListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                onDone(api.getListPopularMovies().results)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    override fun getDetailsInfo(
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

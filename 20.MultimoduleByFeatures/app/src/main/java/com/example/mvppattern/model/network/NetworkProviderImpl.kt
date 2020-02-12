package com.example.mvppattern.model.network

import com.example.core.dto.MovieInfo
import com.example.core.dto.MoviePreview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@kotlinx.serialization.UnstableDefault
class NetworkProviderImpl (private val api: Api) : NetworkProvider {

    override fun requestListMoviePreviews(
        onDone: (List<com.example.core.dto.MoviePreview>) -> Unit,
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

    override fun requestMovieInfo(
        id: Int,
        onDone: (com.example.core.dto.MovieInfo) -> Unit,
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

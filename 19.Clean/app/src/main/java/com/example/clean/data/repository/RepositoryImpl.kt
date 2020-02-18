package com.example.clean.data.repository

import android.util.Log
import com.example.clean.data.api.Api
import com.example.clean.AppConstants.TMDB_LOG_TAG
import com.example.clean.domain.dto.MovieInfo
import com.example.clean.domain.dto.MoviePreview
import com.example.clean.domain.repo.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RepositoryImpl(private val api: Api) :
    Repository {

    override fun getListMoviePreviews(
        onDone: (List<MoviePreview>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = api.getListPopularMovies().results
                onDone(result)
                Log.d(TMDB_LOG_TAG, "Repository\n" + result.joinToString("\n"))
            } catch (e: Exception) {
                onError(e)
                Log.d(TMDB_LOG_TAG, "Repository\n" + e.stackTrace.joinToString("\n"))
            }
        }
    }


    override fun getMovieInfo(
        id: Int,
        onDone: (MovieInfo) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = api.getMovie(id)
                onDone(result)
                Log.d(TMDB_LOG_TAG, result.toString())
            } catch (e: java.lang.Exception) {
                onError(e)
                Log.d(TMDB_LOG_TAG, e.stackTrace.joinToString("\n"))
            }
        }
    }
}

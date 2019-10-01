package com.example.a03kotlincoroutines.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val movies: List<Movie>, private val context: Context) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

//    val urlscr = "https://image.tmdb.org/t/p/w500"

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvOverview = itemView.tvOverview
        val tvReleaseDate = itemView.tvReleaseDate
        val tvTitle = itemView.tvTitle
        val tvPopularity = itemView.tvPopularity
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.movie_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movies[position]
        holder.tvTitle.text = currentMovie.title
        holder.tvOverview.text = currentMovie.overview
        holder.tvReleaseDate.text = currentMovie.release_date
        holder.tvPopularity.text = currentMovie.popularity.toString()
    }
}
package com.example.a03kotlincoroutines.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.mvp.model.Movie
import com.example.a03kotlincoroutines.network.Api.Companion.IMAGE_URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*


class MovieAdapter(
    private val movies: List<Movie>,
    private val context: Context,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    interface OnItemClickListener {
        fun onItemClicked(movie: Movie)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvReleaseDate: TextView = itemView.tvReleaseDate
        val tvTitle: TextView = itemView.tvTitle
        val tvPopularity: TextView = itemView.tvPopularity
        val ivPoster: ImageView = itemView.ivPoster
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        val holder = MovieViewHolder(view)
        view.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClickListener.onItemClicked(movies[adapterPosition])
            }
        }
        return holder
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movies[position]
        holder.tvTitle.text = currentMovie.title
        holder.tvReleaseDate.text = currentMovie.release_date
        holder.tvPopularity.text = currentMovie.popularity
        Picasso.get()
            .load(IMAGE_URL + currentMovie.poster_path)
            .into(holder.ivPoster)
    }
}

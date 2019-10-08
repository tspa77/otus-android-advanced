package com.example.a03kotlincoroutines.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a03kotlincoroutines.AppConstans
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.mvp.model.MoviePreview
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_movie_item.view.*


class MovieAdapter(
    private val context: Context,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listPreviews: List<MoviePreview> = emptyList()

    interface OnItemClickListener {
        fun onItemClicked(moviePreview: MoviePreview)
    }

    fun setData(listPreviews: List<MoviePreview>) {
        this.listPreviews = listPreviews
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvReleaseDate: TextView = itemView.tvReleaseDate
        val tvTitle: TextView = itemView.tvTitle
        val tvPopularity: TextView = itemView.tvPopularity
        val ivPoster: ImageView = itemView.ivPoster
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_movie_item, parent, false)
        val holder = MovieViewHolder(view)
        view.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClickListener.onItemClicked(listPreviews[adapterPosition])
            }
        }
        return holder
    }

    override fun getItemCount(): Int {
        return listPreviews.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = listPreviews[position]
        holder.tvTitle.text = currentMovie.title
        holder.tvReleaseDate.text = currentMovie.release_date
        holder.tvPopularity.text = currentMovie.popularity
        Picasso.get()
            .load(AppConstans.IMAGE_URL + currentMovie.poster_path)
            .into(holder.ivPoster)
    }
}

package com.example.mvppattern.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvppattern.AppConstants
import com.example.mvppattern.data.MoviePreview
import com.example.mvppattern.R
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
        val tvReleaseDate: TextView = itemView.tv_release_date
        val tvTitle: TextView = itemView.tv_title
        val tvPopularity: TextView = itemView.tv_popularity
        val ivPoster: ImageView = itemView.iv_poster
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
        holder.tvReleaseDate.text = currentMovie.releaseDate
        holder.tvPopularity.text = currentMovie.popularity
        Picasso.get()
            .load(AppConstants.IMAGE_URL + currentMovie.posterPath)
            .into(holder.ivPoster)
    }
}

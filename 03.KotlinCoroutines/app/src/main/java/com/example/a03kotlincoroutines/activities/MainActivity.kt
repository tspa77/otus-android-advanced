package com.example.a03kotlincoroutines.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.data.MovieAdapter
import com.example.a03kotlincoroutines.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies.layoutManager = LinearLayoutManager(this)
        rvMovies.adapter = MovieAdapter(mockMovies(), this)
    }


    fun mockMovies():List<Movie>{
        val movies = mutableListOf<Movie>()
        movies.add(Movie("path", "Отличное кино", "1997-08-03", 10, "Матрица", 100))
        movies.add(Movie("path", "Хорошее такое кино", "2016-05-01", 40, "Скала", 85))
        movies.add(Movie("path", "Херня какая-то", "2013-11-11", 21, "Хрень", 12))
        movies.add(Movie("path", "Не смотрел но осуждаю", "2018-02-01", 11, "Кинцо", 55))
        return movies
    }
}

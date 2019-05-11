package com.hnam.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
@SuppressLint("SetTextI18n")

class MoviesActivity : AppCompatActivity() {

    var movies: ArrayList<MovieModel.Results> = ArrayList()

    lateinit var movieAdapter: MovieAdapter
    val model = MovieModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addMovies()

        // setup layout manager and recyclerview
        movie_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?

        movieAdapter = MovieAdapter(movies, this)

        movie_list.adapter = movieAdapter



        movieAdapter.setListener(movieItemClickListenner)
    }

    private val movieItemClickListenner = object: MovieItemClickListenner {
        override fun onItemCLicked(position: Int) {

            val intent = Intent(this@MoviesActivity,ProfileActivity::class.java)
            intent.putExtra(MOVIE_TITILE_KEY, movies[position].title)
            intent.putExtra(MOVIE_CONTENT_KEY, movies[position].video)
            intent.putExtra(MOVIE_POSTER_PATH_KEY, movies[position].overview)
            intent.putExtra(MOVIE_VOTE_KEY, movies[position].poster_path)
            intent.putExtra(MOVIE_VIDEO_KEY, movies[position].vote_average)
            startActivity(intent)

        }
    }
    private fun addMovies() {
        for (i in model.getMovieModel().results) {
            movies.add(i)
            Log.i("film array", movies.toString())
        }
    }
}

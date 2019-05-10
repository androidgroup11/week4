package com.hnam.recyclerview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_list.view.*

class MoviesActivity : AppCompatActivity() {
    var movie: ArrayList<Movie.Results> = ArrayList()
    lateinit var movieAdapter :MovieAdapter
    var model = Movie()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addMovies()
        movie_list.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter(movie,this)
        movie_list.adapter = movieAdapter
        movieAdapter.setListenner(movieItemClickListener)

    }

    private fun addMovies(){
        for(i in model.getMovieModel().results){
            movie.add(i)
            Log.i("film array", movie.toString())
        }
}

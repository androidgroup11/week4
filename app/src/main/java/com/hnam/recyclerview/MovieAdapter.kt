package com.hnam.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_list.view.*

class MovieAdapter(val items: ArrayList<Movie>, val context: Context): RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, position: Int) {
        movieViewHolder.tvName.text = items.get(position).title
        movieViewHolder.tvReleaseDate.text = "Release date: "+items.get(position).release_date
        movieViewHolder.tvLanguage.text = "Original language: "+items.get(position).original_language
        movieViewHolder.tvPopularity.text = "Popularity: "+items.get(position).popularity
        movieViewHolder.tvVote.text = "Vote count: "+items.get(position).vote_count
        var value_video: Boolean = items.get(position).video
        if(value_video ==true){
            movieViewHolder.tvPlay.visibility = View.VISIBLE
        }
        else
        {
            movieViewHolder.tvPlay.visibility = View.INVISIBLE
        }

        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500/"+items.get(position).poster_path)
            .centerCrop()
            .placeholder(R.drawable.student)
            .into(movieViewHolder.tvAvatar)
        movieViewHolder.itemView.setOnClickListener{
            mListener.onItemClicked(position)
        }
    }
    fun setListenner(listener: FilmItemClickListener){
        this.mListener = listener
    }
    }
    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvAvatar = view.ivAvatar
        var tvName = view.NameFilm
        var tvPlay = view.play
        var tvReleaseDate = view.Release
        var tvLanguage = view.language
        var tvPopularity = view.popularity
        var tvVote = view.vote_count

    }
}
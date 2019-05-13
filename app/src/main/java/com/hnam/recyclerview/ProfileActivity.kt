package com.hnam.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        getAndPutData()
    }

    private fun getAndPutData() {
        val data = intent.extras

        if (data != null) {
            val content =data.getString(MOVIE_CONTENT_KEY)
            val play_video = data.getBoolean(MOVIE_VIDEO_KEY)
            val poster_path2 = data.getString(MOVIE_POSTER_PATH_KEY)
            val vote = data.getDouble(MOVIE_VOTE_KEY)
            val title = data.getString(MOVIE_TITILE_KEY)
            Title.text= title
            tvContent.text = content
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/"+poster_path2)
                .centerCrop()
                .placeholder(R.drawable.student)
                .into(poster)
            if (play_video == true){
                tvPlay.visibility = View.VISIBLE
            }
            else
            {
                tvPlay.visibility = View.INVISIBLE
            }

            idVote.rating = (vote/2).toFloat()
        }
    }
}


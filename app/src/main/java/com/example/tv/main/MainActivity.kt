package com.example.tv.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tv.main.rtr.Inter
import com.example.tv.main.model.ModelMovie
import com.example.tv.R
import com.example.tv.main.model.All
import com.example.tv.movie.Model
import com.example.tv.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.img_card.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = Inter.api
        val call = service.getFilms("filter")
        call.enqueue(object : Callback<All> {
            override fun onResponse(call: Call<All>, response: Response<All>) {
                Log.d("BLOOP2", response.body().toString())
                val result: ModelMovie = response.body() as ModelMovie
               //img_card_img.toString() = result.images.toString()
            }

            override fun onFailure(call: Call<All>, t: Throwable) {
                Log.d("BLOOP2","FATAL")
            }


        })

    }

    fun look(view: View) {
        val intent = Intent(this, MovieActivity::class.java)
                startActivity(intent)

    }
}
package com.example.tv.movie

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.VideoView
import com.example.tv.R
import com.example.tv.main.rtr.Inter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val video :VideoView = findViewById(R.id.video)
        video.setVideoURI(Uri.parse("http://cinema.areas.su/up/video/trailer.mp4"))
        video.requestFocus()
        video.start()


        val service = Inter.api
        val call = service.getMovie(1)
        call.enqueue(object :Callback<List<Model>>{
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                Log.d("Bloop", response.body().toString())
            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Log.d("Bloop", "FATAL")
            }

        })

    }
}
package com.example.tv.main.rtr

import com.example.tv.main.model.ModelMovie
import com.example.tv.login.mdel.ModelInto
import com.example.tv.login.mdel.ModelTo
import com.example.tv.main.model.All
import com.example.tv.movie.Model
import retrofit2.Call
import retrofit2.http.*

interface Service {

    @POST("auth/login")
    fun getLog(@Body ModelInto: ModelInto): Call<ModelTo>

    @GET("movies")
    fun getFilms(@Query("filter") filter: String) : Call<All>

    @GET("movies/{movieId}/episodes")
    fun getMovie(@Path("movieId") movieId : Int) : Call<List<Model>>
}
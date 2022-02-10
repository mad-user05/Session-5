package com.example.tv.main.rtr

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Inter {
    val URL = "http://cinema.areas.su/up/images/"

    val retrofit by lazy {
        Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api : Service by lazy {
        retrofit.create(Service::class.java)
    }
}
package com.prueba.reddit.value_object

import com.google.gson.GsonBuilder
import com.prueba.reddit.domain.post.ServicesPost
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val wspost by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.reddit.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(ServicesPost::class.java)
    }
}
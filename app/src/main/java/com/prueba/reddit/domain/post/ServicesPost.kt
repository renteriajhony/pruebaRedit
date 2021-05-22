package com.prueba.reddit.domain.post

import com.prueba.reddit.data.model.post.Cabecera
import retrofit2.http.GET

interface ServicesPost {
    @GET("top.json")
    suspend fun getAll(): Cabecera
}
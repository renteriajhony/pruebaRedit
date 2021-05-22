package com.prueba.reddit.data

import com.prueba.reddit.data.model.post.Cabecera
import com.prueba.reddit.data.model.post.Post
import com.prueba.reddit.value_object.RetrofitClient
import com.repaso.reddit.value_object.Resource

class PostDataSet {
    suspend fun getAll(): Resource<Cabecera> {
        return Resource.Success(RetrofitClient.wspost.getAll())
    }
}
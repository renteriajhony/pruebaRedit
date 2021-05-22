package com.prueba.reddit.domain.post

import com.prueba.reddit.data.model.post.Cabecera
import com.prueba.reddit.data.model.post.Post
import com.repaso.reddit.value_object.Resource

interface RepoPost {
    suspend fun getAllPosts(): Resource<Cabecera>
}
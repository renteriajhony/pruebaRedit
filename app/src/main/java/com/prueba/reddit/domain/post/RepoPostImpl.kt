package com.prueba.reddit.domain.post

import com.prueba.reddit.data.PostDataSet
import com.prueba.reddit.data.model.post.Cabecera
import com.prueba.reddit.data.model.post.Post
import com.repaso.reddit.value_object.Resource

class RepoPostImpl(private val postDataSet: PostDataSet): RepoPost {
    override suspend fun getAllPosts(): Resource<Cabecera> {
        return postDataSet.getAll()
    }
}
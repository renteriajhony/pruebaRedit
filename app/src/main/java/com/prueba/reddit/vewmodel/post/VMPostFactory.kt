package com.prueba.reddit.vewmodel.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prueba.reddit.domain.post.RepoPost

class VMPostFactory(private val repoPosts: RepoPost): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RepoPost::class.java).newInstance(repoPosts)
    }
}
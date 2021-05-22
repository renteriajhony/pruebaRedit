package com.prueba.reddit.vewmodel.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.prueba.reddit.domain.post.RepoPost
import com.prueba.reddit.ui.PostActivity
import com.repaso.reddit.value_object.Resource
import kotlinx.coroutines.Dispatchers


class PostViewModel(private val repoPosts: RepoPost): ViewModel() {

    val fetchPostsList = liveData(Dispatchers.IO) {
        emit(Resource.Loading<List<PostActivity>>())
        try {
            emit(repoPosts.getAllPosts())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}
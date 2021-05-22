package com.prueba.reddit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prueba.reddit.R
import com.prueba.reddit.data.PostDataSet
import com.prueba.reddit.data.model.post.Cabecera
import com.prueba.reddit.databinding.ActivityMainBinding
import com.prueba.reddit.databinding.ActivityPostBinding
import com.prueba.reddit.domain.post.RepoPostImpl
import com.prueba.reddit.ui.adapter.PostAdapter
import com.prueba.reddit.vewmodel.post.PostViewModel
import com.prueba.reddit.vewmodel.post.VMPostFactory
import com.repaso.reddit.value_object.Resource

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    private val viewModel by viewModels<PostViewModel> {
        VMPostFactory(RepoPostImpl(PostDataSet()))
    }

    lateinit var cabecera: Cabecera

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        prepareInicialData()
    }

    fun prepareInicialData() {
        val postObserver = Observer<Resource<Any>> { result ->
            when (result) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    cabecera = result.data as Cabecera
                    binding.rvPost.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                    val adapter = PostAdapter(this.cabecera)
                    binding.rvPost.adapter = adapter
                    //Log.d("****:",result.data.toString())
                }
                is Resource.Failure -> {
                    Log.d("****:",result.toString())
                    Toast.makeText(this, "Ocurrio un error cargando los datos ", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.fetchPostsList.observe(this, postObserver)
    }
}
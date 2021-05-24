package com.prueba.reddit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prueba.reddit.R
import com.prueba.reddit.data.model.post.Post
import com.prueba.reddit.databinding.ActivityPremiosBinding
import com.prueba.reddit.ui.adapter.PremiosAdapter

class PremiosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPremiosBinding
    private lateinit var post: Post
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPremiosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (intent.extras != null){

            try {
             val bundle = intent.extras!!.getBundle("bundle")
                post = bundle?.getParcelable<Post>("post")!!
            }catch (e:Exception){
                 Log.e("Error messaje", e.message.toString())
                 Log.e("Error localizedMessage", e.localizedMessage.toString())

            }

            binding.rvPremios.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            val adapter = PremiosAdapter(this.post)
            binding.rvPremios.adapter = adapter
        }
    }
}
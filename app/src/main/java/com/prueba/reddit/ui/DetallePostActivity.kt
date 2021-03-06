package com.prueba.reddit.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.MediaController
import com.prueba.reddit.data.model.post.Post
import com.prueba.reddit.databinding.ActivityDetallePostBinding
import com.prueba.reddit.ui.adapter.PostAdapter
import com.squareup.picasso.Picasso

class DetallePostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetallePostBinding
    private lateinit var post: Post
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (intent.extras != null){
            val bundle = intent.extras!!.getBundle("bundle")
            post = bundle?.getParcelable<Post>("post")!!
            println(post.toString())
        }

        viewDetalleData(post)


        binding.llPremios.setOnClickListener {
            openPremios(post)
        }
    }

    private fun viewDetalleData(post: Post) {
        val textlikes = if (post.ups > 1000)
            String.format("%.1f", (post.ups/1000f)).toString()+"mil"
        else post.ups.toString()

        val textcoment = if (post.numComments > 1000)
            String.format("%.1f", (post.numComments/1000f)).toString()+"mil"
        else post.numComments.toString()
        getImgPremios(post)
        binding.title.text = post.title
        Picasso.get().load(post.thumbnail).into(binding.ivAutor)
        binding.tvPrefijoAutor.text= post.subredditNamePrefixed
        binding.tvAutor.text= post.author
        binding.tvTotalpremios.text= post.totalAwardsReceived.toString()+" Premios"
        Picasso.get().load(post.thumbnail).into(binding.ivPost)
        binding.tvDominio.text= post.domain
        binding.tvTotallikes.text= textlikes
        binding.tvTotalcomentarios.text= textcoment
        postVideoView(post)
    }

    fun getImgPremios(post: Post){
        val layoutParams = LinearLayout.LayoutParams(50, 50)
        layoutParams.setMargins(0, 0, 8, 8)

        for (index in 0..3) {
            var iv = ImageView(binding.llPremios.context)
            iv.layoutParams = layoutParams
            iv.x = 8F //setting margin from left
            iv.y = 8F //setting margin from top
            Picasso.get().load(post.allAwardings.get(index).iconUrl).into(iv)
            binding.llPremios.addView(iv)
        }

    }

    fun openPremios(post: Post) {
        val intent = Intent(this,PremiosActivity::class.java)
        var bundle = Bundle()
        bundle.putParcelable("post",post)
        intent.putExtra("bundle",bundle)
        startActivity(intent)
    }

    fun postVideoView(post: Post){

            if(!post.preview.redditVideoPreview?.fallbackUrl.isNullOrEmpty()){
                var mediaControls: MediaController? = null
                mediaControls = MediaController(binding.vvDetallePost.context)
                mediaControls!!.setAnchorView(binding.vvDetallePost)
                binding.vvDetallePost!!.setVideoURI(Uri.parse(post.preview.redditVideoPreview?.fallbackUrl.toString()))
                binding.vvDetallePost!!.requestFocus()
                // starting the video
                binding.vvDetallePost!!.start()
                binding.vvDetallePost.visibility = View.VISIBLE
            }

        if(!post.preview.redditVideoPreview?.fallbackUrl.isNullOrEmpty()){
            binding.pbLoadvideo.visibility = View.VISIBLE
            binding.vvDetallePost.visibility = View.VISIBLE
            var mediaControls: MediaController? = null
             mediaControls = MediaController(binding.vvDetallePost.context)
             mediaControls!!.setAnchorView(binding.vvDetallePost)
             mediaControls.setMediaPlayer(binding.vvDetallePost)
            binding.vvDetallePost.setMediaController(mediaControls)
            binding.vvDetallePost!!.setVideoURI(Uri.parse(post.preview.redditVideoPreview?.fallbackUrl.toString()))
            binding.vvDetallePost.setOnPreparedListener{mp ->
                mp.isLooping = true
                binding.pbLoadvideo.visibility = View.GONE

                Log.i("PrepareListener","Duration = " + binding.vvDetallePost.duration)
            }
            binding.vvDetallePost!!.requestFocus()
            // starting the video
            binding.vvDetallePost!!.start()

        }else{
            binding.pbLoadvideo.visibility = View.GONE
            binding.vvDetallePost.visibility = View.GONE
        }
    }
}
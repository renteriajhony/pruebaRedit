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

       /* try {
            val bundle = intent.extras!!.getBundle("bundle")
            post = bundle?.getParcelable<Post>("post")!!
            println(post.toString())
        }catch (e:Exception){
            Log.e("Error messaje", e.message.toString())
            Log.e("Error localizedMessage", e.localizedMessage.toString())

        }*/

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
        //binding.wvMedia1.loadUrl(post.url.toString())

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

        //http://i.stack.imgur.com/e8nZC.gif

    }

    fun openPremios(post: Post) {
        val intent = Intent(this,PremiosActivity::class.java)
        var bundle = Bundle()
        bundle.putParcelable("post",post)
        intent.putExtra("bundle",bundle)
        startActivity(intent)
    }

    fun postVideoView(post: Post){
        try {
            if(post.preview.redditVideoPreview?.fallbackUrl.toString().contains("http")){
                var mediaControls: MediaController? = null
                mediaControls = MediaController(binding.vvDetallePost.context)
                mediaControls!!.setAnchorView(binding.vvDetallePost)
                binding.vvDetallePost!!.setVideoURI(Uri.parse(post.preview.redditVideoPreview?.fallbackUrl.toString()))
                binding.vvDetallePost!!.requestFocus()
                // starting the video
                binding.vvDetallePost!!.start()
                binding.vvDetallePost.visibility = View.VISIBLE
            }
        }catch (e: Exception){
            Log.e("Error",e.message.toString())
        }

    }
}
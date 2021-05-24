package com.prueba.reddit.ui.adapter

import android.app.ProgressDialog
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.prueba.reddit.R
import com.prueba.reddit.data.model.post.AllAwardings
import com.prueba.reddit.data.model.post.Cabecera
import com.prueba.reddit.data.model.post.Post
import com.prueba.reddit.ui.PremiosActivity
import com.squareup.picasso.Picasso

class PostAdapter(
    private val cabecera: Cabecera,
    private val onAdapterClickListener: OnAdapterClickListener
) : RecyclerView.Adapter<PostAdapter.PostHolder>() {

    interface OnAdapterClickListener {
        fun onPremiosClick(post: Post)
        fun onDetalleClick(post: Post)
        fun onDomainClick(post: Post, webView: WebView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_post, parent, false)

        return PostHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post: Post = cabecera.data.children.get(position).data
        val textlikes = if (post.ups > 1000)
            String.format("%.1f", (post.ups / 1000f)).toString() + "mil"
        else post.ups.toString()

        val textcoment = if (post.numComments > 1000)
            String.format("%.1f", (post.numComments / 1000f)).toString() + "mil"
        else post.numComments.toString()

        holder.title.text = post.title
        Picasso.get().load(post.thumbnail).into(holder.iv_autor)
        holder.tv_prefijo_autor.text = post.subredditNamePrefixed
        holder.tv_autor.text = post.author
        holder.tv_totalpremios.text = post.totalAwardsReceived.toString() + " Premios"
        Picasso.get().load(post.thumbnail).into(holder.iv_post)
        holder.tv_dominio.text = post.domain
        holder.tv_totallikes.text = textlikes
        holder.tv_totalcomentarios.text = textcoment

        postVideoView(holder, post)
        getImgPremios(holder, post)

        holder.ll_premios.setOnClickListener {
            onAdapterClickListener.onPremiosClick(post)
        }

        holder.title.setOnClickListener {
            onAdapterClickListener.onDetalleClick(post)
        }

        holder.tv_dominio.setOnClickListener {
            onAdapterClickListener.onDomainClick(post, holder.wv_media)
        }
        holder.iv_post.setOnClickListener {
            onAdapterClickListener.onDomainClick(post, holder.wv_media)
        }
    }

    fun getImgPremios(holder: PostHolder, post: Post) {
        holder.ll_premios.removeAllViews()
        val layoutParams = LinearLayout.LayoutParams(40, 40)
        layoutParams.setMargins(0, 0, 8, 8)

        for (index in 0..3) {
            var iv = ImageView(holder.ll_premios.context)
            iv.layoutParams = layoutParams
            iv.x = 8F //setting margin from left
            iv.y = 8F //setting margin from top
            Picasso.get().load(post.allAwardings.get(index).iconUrl).into(iv)
            holder.ll_premios.addView(iv)
        }
    }

    override fun getItemCount(): Int = cabecera.data.children.size

    class PostHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val iv_autor: ImageView
        val tv_prefijo_autor: TextView
        val tv_autor: TextView
        val tv_totalpremios: TextView
        val title: TextView
        val iv_post: ImageView
        val tv_dominio: TextView
        val tv_totallikes: TextView
        val tv_totalcomentarios: TextView
        val ll_premios: LinearLayout
        val wv_media: WebView
        val vvPost: VideoView
        val pb_loadvideo: ProgressBar

        init {
            iv_autor = this.view.findViewById(R.id.iv_autor)
            tv_prefijo_autor = this.view.findViewById(R.id.tv_prefijo_autor)
            tv_autor = this.view.findViewById(R.id.tv_autor)
            tv_totalpremios = this.view.findViewById(R.id.tv_totalpremios)
            title = this.view.findViewById(R.id.title)
            iv_post = this.view.findViewById(R.id.iv_post)
            tv_dominio = this.view.findViewById(R.id.tv_dominio)
            tv_totallikes = this.view.findViewById(R.id.tv_totallikes)
            tv_totalcomentarios = this.view.findViewById(R.id.tv_totalcomentarios)
            ll_premios = this.view.findViewById(R.id.ll_premios)
            wv_media = this.view.findViewById(R.id.wv_media)
            vvPost = this.view.findViewById(R.id.vvPost)
            pb_loadvideo = this.view.findViewById(R.id.pb_loadvideo)
        }
    }

    fun postVideoView(holder: PostHolder, post: Post) {

        try {
            if (!post.preview.redditVideoPreview?.fallbackUrl.isNullOrEmpty()) {
                holder.pb_loadvideo.visibility = View.VISIBLE
                holder.vvPost.visibility = View.VISIBLE
                var mediaControls: MediaController? = null
                mediaControls = MediaController(holder.vvPost.context)
                holder.vvPost!!.setVideoURI(Uri.parse(post.preview.redditVideoPreview?.fallbackUrl.toString()))
                holder.vvPost.setOnPreparedListener { mp ->
                    mp.isLooping = true
                    holder.pb_loadvideo.visibility = View.GONE
                }
                holder.vvPost!!.requestFocus()
                holder.vvPost!!.start()

            } else {
                holder.pb_loadvideo.visibility = View.GONE
                holder.vvPost.visibility = View.GONE
            }
        } catch (e: Exception) {
            holder.pb_loadvideo.visibility = View.GONE
            holder.vvPost.visibility = View.GONE
        }


    }

}
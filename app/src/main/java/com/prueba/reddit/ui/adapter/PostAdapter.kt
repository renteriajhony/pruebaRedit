package com.prueba.reddit.ui.adapter

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.recyclerview.widget.RecyclerView
import com.prueba.reddit.R
import com.prueba.reddit.data.model.post.Cabecera
import com.prueba.reddit.data.model.post.Children
import com.prueba.reddit.data.model.post.Post
import com.squareup.picasso.Picasso

class PostAdapter(val cabecera:Cabecera): RecyclerView.Adapter<PostAdapter.PostHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val layoutInflater = LayoutInflater.from(parent.context).
        inflate(R.layout.adapter_post, parent, false)

        return PostHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post: Post = cabecera.data.children.get(position).data
        val textlikes = if (post.ups > 1000)
                            String.format("%.1f", (post.ups/1000f)).toString()+"mil"
                        else post.ups.toString()

        val textcoment = if (post.numComments > 1000)
                            String.format("%.1f", (post.numComments/1000f)).toString()+"mil"
                         else post.numComments.toString()

        holder.title.text = post.title
        Picasso.get().load(post.thumbnail).into(holder.iv_autor)
        holder.tv_prefijo_autor.text= post.subredditNamePrefixed
        holder.tv_autor.text= post.author
        holder.tv_totalpremios.text= post.totalAwardsReceived.toString()+" Premios"
        Picasso.get().load(post.thumbnail).into(holder.iv_post)
        holder.tv_dominio.text= post.domain
        holder.tv_totallikes.text= textlikes
        holder.tv_totalcomentarios.text= textcoment

        getImgPremios(holder,post)




    }

    fun getImgPremios(holder: PostHolder,post: Post){
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

    class PostHolder(val view: View): RecyclerView.ViewHolder(view){

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

        init {
            iv_autor  = this.view.findViewById(R.id.iv_autor)
            tv_prefijo_autor  = this.view.findViewById(R.id.tv_prefijo_autor)
            tv_autor = this.view.findViewById(R.id.tv_autor)
            tv_totalpremios = this.view.findViewById(R.id.tv_totalpremios)
            title = this.view.findViewById(R.id.title)
            iv_post  = this.view.findViewById(R.id.iv_post)
            tv_dominio = this.view.findViewById(R.id.tv_dominio)
            tv_totallikes = this.view.findViewById(R.id.tv_totallikes)
            tv_totalcomentarios = this.view.findViewById(R.id.tv_totalcomentarios)
            ll_premios = this.view.findViewById(R.id.ll_premios)

        }
    }

}
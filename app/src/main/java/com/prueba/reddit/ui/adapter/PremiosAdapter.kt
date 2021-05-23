package com.prueba.reddit.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prueba.reddit.R
import com.prueba.reddit.data.model.post.Post
import com.squareup.picasso.Picasso

class PremiosAdapter(
    private val post: Post
): RecyclerView.Adapter<PremiosAdapter.PremiosHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PremiosHolder {
        val layoutInflater = LayoutInflater.from(parent.context).
        inflate(R.layout.adapter_premios, parent, false)

        return PremiosHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PremiosHolder, position: Int) {
        holder.tv_total.text = post.allAwardings.get(position).count.toString()
        Picasso.get().load(post.allAwardings.get(position).iconUrl).into(holder.iv_premio)
        holder.iv_nombre.text= post.allAwardings.get(position).name
    }

    override fun getItemCount(): Int = post.allAwardings.size

    class PremiosHolder(val view: View): RecyclerView.ViewHolder(view){

        val iv_premio: ImageView
        val tv_total: TextView
        val iv_nombre: TextView

        init {
            iv_premio  = this.view.findViewById(R.id.iv_premio)
            tv_total = this.view.findViewById(R.id.tv_total)
            iv_nombre  = this.view.findViewById(R.id.iv_nombre)
        }
    }

}
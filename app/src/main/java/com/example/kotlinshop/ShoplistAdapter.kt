package com.example.kotlinshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.shop.view.*

class ShoplistAdapter(var shoplistitem: List<PostModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class imgviewholder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(postModel: PostModel){
            itemView.name.text = postModel.title
            itemView.location.text = postModel.location

            //load img
            Glide.with(itemView.context).load(postModel.img).into(itemView.imageView)

            //clip img
            itemView.imageView.clipToOutline = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop, parent, false)
        return imgviewholder(view)

    }

    override fun getItemCount(): Int {
        return shoplistitem.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as imgviewholder).bind(shoplistitem[position])

    }


}
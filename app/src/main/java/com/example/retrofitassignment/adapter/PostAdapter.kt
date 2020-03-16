package com.example.retrofitassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitassignment.R
import com.example.retrofitassignment.model.Typicode
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(var postList: List<Typicode>, context: Context) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun  bindPost(typicode: Typicode) {

            itemView.txtTitle.text = typicode.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        holder.bindPost(postList[position])
    }

}

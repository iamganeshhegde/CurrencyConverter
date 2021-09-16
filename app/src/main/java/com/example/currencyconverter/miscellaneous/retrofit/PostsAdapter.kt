package com.example.currencyconverter.miscellaneous.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R


class PostsAdapter(var context: Context?, var postsList: List<Posts>?): RecyclerView.Adapter<PostViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): PostViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: PostViewHolder, position: Int) {
        holder.txtAuthor!!.text = postsList!![position].userId.toString()
        holder.txtTitle!!.text = postsList!![position].title.toString()
        holder.txtContent!!.text = StringBuilder(postsList!![position].body!!.substring(0, 20))
            .append("...").toString()
    }

    override fun getItemCount(): Int {
        return postsList!!.size
    }
}
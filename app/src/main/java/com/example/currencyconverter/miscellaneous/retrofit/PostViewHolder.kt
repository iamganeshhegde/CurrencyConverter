package com.example.currencyconverter.miscellaneous.retrofit

import com.example.currencyconverter.R

import android.view.View

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var txtTitle: TextView? = null
    var txtContent:TextView? = null
    var txtAuthor:TextView? = null
    init {
        txtTitle = itemView.findViewById(R.id.txtTitle)
        txtContent = itemView.findViewById<TextView>(R.id.txtContent)
        txtAuthor = itemView.findViewById<TextView>(R.id.txtAuthor)
    }


}
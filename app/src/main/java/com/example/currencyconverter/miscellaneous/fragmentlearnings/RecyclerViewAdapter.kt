package com.example.currencyconverter.miscellaneous.fragmentlearnings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R

class RecyclerViewAdapter(var context: Context, var list: MutableList<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == VIEW_TYPE_ONE) {
            return ViewHolder1(LayoutInflater.from(context).inflate(R.layout.item_view_1,parent,false))
        }
        return ViewHolder2(LayoutInflater.from(context).inflate(R.layout.item_view_2,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(list[position].viewType == VIEW_TYPE_ONE) {
            (holder as ViewHolder1).bind(position)
        } else {
            (holder as ViewHolder2).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }



    inner class ViewHolder1(view: View): RecyclerView.ViewHolder(view) {

        var message = itemView.findViewById<TextView>(R.id.item_text_view_1)

        fun bind(position:Int) {
            var model = list[position]
            message.text = model.textData
        }

    }

    inner class ViewHolder2(view: View): RecyclerView.ViewHolder(view) {
        var message2 = itemView.findViewById<TextView>(R.id.item_text_view_2)

        fun bind(position:Int) {
            var model = list[position]
            message2.text = model.textData
        }

    }

}

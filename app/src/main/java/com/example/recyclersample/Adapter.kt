package com.example.recyclersample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    val context: Context?,
    var itemlist: List<Items>,
    private val clicklistener: (Int) -> Unit,
    private val longclicklistener: (Int) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            layoutInflater.inflate(R.layout.listitem, parent, false)
        )
    }

    override fun getItemCount(): Int = itemlist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemlist[position], clicklistener, longclicklistener)
    }

    fun update(newList: List<Items>) {
        itemlist = newList
    }
}
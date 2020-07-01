package com.example.recyclersample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listitem.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Items, clicklistener: (Int) -> Unit, longclicklistener: (Int) -> Unit) =
        with(itemView) {
            titleTxtView.text = item.title
            descriptionTxtView.text = item.description
            imageView.setImageResource(item.image)
            setOnClickListener { clicklistener(adapterPosition) }
            setOnLongClickListener {
                longclicklistener(adapterPosition)
                true
            }
        }
}
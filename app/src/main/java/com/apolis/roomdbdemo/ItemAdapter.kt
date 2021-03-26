package com.apolis.roomdbdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val NORMAL_VIEW = 1
    val COMPLEX_VIEW = 2

    var onCreateViewHolderCount = 0
    var onBindViewHolderCount = 0

    class NormalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var view : ImageView  ? = null

        init {

            view  = itemView.findViewById(R.id.image)
        }

    }


    class SecondaryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var view : TextView? = null

        init {

            view  = itemView.findViewById(R.id.text)
        }


    }

    override fun getItemViewType(position: Int): Int {
        if(position % 2 == 0) {
            return NORMAL_VIEW
        } else {
            return COMPLEX_VIEW
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder : RecyclerView.ViewHolder

        if(viewType == NORMAL_VIEW) {
            viewHolder = NormalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.normal_item, parent,false))
        } else {
            viewHolder = SecondaryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.complex_item, parent,false))
        }

        onCreateViewHolderCount++
        Log.d(Companion.TAG, "onCreateViewHolder: $onCreateViewHolderCount")

        return viewHolder

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        onBindViewHolderCount++
        Log.d(TAG, "onBindViewHolder: $onBindViewHolderCount")
    
    }

    override fun getItemCount(): Int {
        return 100
    }

    companion object {
        private const val TAG = "ItemAdapter"
    }
}
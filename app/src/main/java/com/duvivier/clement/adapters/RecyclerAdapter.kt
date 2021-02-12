package com.duvivier.clement.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duvivier.clement.R
import com.duvivier.clement.model.Nom
import com.duvivier.clement.model.People

class RecyclerAdapter(private val liste : List<Nom>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val texteView : TextView = itemView.findViewById(R.id.tv_test)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context : Context = parent.context
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.items_rv_menu, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.texteView.text = liste[position].name
    }

    override fun getItemCount(): Int {
        return liste.size
    }
}

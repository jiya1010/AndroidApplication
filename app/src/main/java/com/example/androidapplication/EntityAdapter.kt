package com.example.androidapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.nit3213.data.Entity

class EntityAdapter(
    private val entity: List<Entity>,
    private val onItemClicked: (String) -> Unit
) :
    RecyclerView.Adapter<EntityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_entity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = entity[position]
        holder.textView.text=model.property1?:"Data Is Null"

        holder.itemView.setOnClickListener {
            onItemClicked(model.description)
        }

    }

    override fun getItemCount(): Int {
        return entity.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)

    }
}

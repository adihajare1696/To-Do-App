package com.example.to_do

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        when (data[position].priority.lowercase()) {
            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium" -> holder.layout.setBackgroundColor(Color.parseColor("#edc988"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
        }

        holder.title.text = data[position].title
        holder.priority.text = data[position].priority
        holder.layout.visibility = View.VISIBLE
        holder.title.visibility = View.VISIBLE
        holder.priority.visibility = View.VISIBLE
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,UpdateCard::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var priority = itemView.findViewById<TextView>(R.id.priority)
        var layout = itemView.findViewById<LinearLayout>(R.id.myLayout)
    }
}
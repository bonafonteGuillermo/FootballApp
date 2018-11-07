package app.demo.example.com.footballapp.areas.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.model.Area
import kotlinx.android.synthetic.main.item_area.view.*
import kotlin.properties.Delegates

typealias Listener = (Area) -> Unit

class ParentAreaAdapter(data: List<Area> = arrayListOf(), private val listener: Listener) :
        RecyclerView.Adapter<ParentAreaAdapter.MyParentAreaViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyParentAreaViewHolder =
            MyParentAreaViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_area, parent, false), listener)

    override fun onBindViewHolder(holder: MyParentAreaViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class MyParentAreaViewHolder(view: View, private val listener: Listener) :
            RecyclerView.ViewHolder(view) {

        fun bind(item: Area) = with(itemView) {
            tv_area_name.text = item.name
            setOnClickListener { listener(item) }
        }
    }
}
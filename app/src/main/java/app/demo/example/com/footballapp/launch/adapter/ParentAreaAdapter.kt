package app.demo.example.com.footballapp.launch.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.model.Area
import kotlinx.android.synthetic.main.parent_area_item_layout.view.*
import kotlin.properties.Delegates

typealias Listener = (Area) -> Unit

class ParentAreaAdapter(data: List<Area> = emptyList(), private val listener: Listener) :
        RecyclerView.Adapter<ParentAreaAdapter.MyParentAreaViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyParentAreaViewHolder =
            MyParentAreaViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.parent_area_item_layout, parent, false), listener)

    override fun onBindViewHolder(holder: MyParentAreaViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class MyParentAreaViewHolder(view: View, private val listener: Listener) :
            RecyclerView.ViewHolder(view) {

        fun bind(item: Area) = with(itemView) {
            tv_parent_area_name.text = item.parentArea
            setOnClickListener { listener(item) }
        }
    }
}
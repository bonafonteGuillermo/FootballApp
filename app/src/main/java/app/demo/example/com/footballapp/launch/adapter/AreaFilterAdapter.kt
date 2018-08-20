package app.demo.example.com.footballapp.launch.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.model.Area
import kotlinx.android.synthetic.main.item_area_filter.view.*
import kotlin.properties.Delegates

typealias FilterListener = (Area,Int) -> Unit

class AreaFilterAdapter(data: List<Area> = emptyList(), private val listener: FilterListener) :
        RecyclerView.Adapter<AreaFilterAdapter.MyAreaFilterViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAreaFilterViewHolder =
            MyAreaFilterViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_area_filter, parent, false), listener)

    override fun onBindViewHolder(holder: MyAreaFilterViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bind(data[position],position)
    }

    override fun getItemCount(): Int = data.size

    class MyAreaFilterViewHolder(view: View, private val listener: FilterListener) :
            RecyclerView.ViewHolder(view) {

        fun bind(item: Area, position: Int) = with(itemView) {
            tv_filter_name.text = item.parentArea
            setOnClickListener { listener(item,position) }
        }
    }
}
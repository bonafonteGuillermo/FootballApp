package app.demo.example.com.footballapp.launch.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.properties.Delegates
import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.R
import kotlinx.android.synthetic.main.item_area_filter.view.*

typealias FilterListener = (Area) -> Unit

class AreaFilterAdapter(data: List<Area> = emptyList(), private val listener: FilterListener) :
        RecyclerView.Adapter<AreaFilterAdapter.MyAreaFilterViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAreaFilterViewHolder =
            MyAreaFilterViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_area_filter, parent, false), listener)

    override fun onBindViewHolder(holder: MyAreaFilterViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class MyAreaFilterViewHolder(view: View, private val listener: FilterListener) :
            RecyclerView.ViewHolder(view) {

        fun bind(item: Area) = with(itemView) {
            tv_filter_name.text = item.parentArea
            setOnClickListener { listener(item) }
        }
    }
}
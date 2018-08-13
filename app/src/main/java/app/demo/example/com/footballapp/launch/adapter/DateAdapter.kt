package app.demo.example.com.footballapp.launch.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*
import kotlin.properties.Delegates
import app.demo.example.com.footballapp.R
import kotlinx.android.synthetic.main.item_date_filter.view.*
import java.text.SimpleDateFormat

typealias DateListener = (Date) -> Unit

class DateAdapter(data: List<Date> = emptyList(), private val listener: DateListener) :
        RecyclerView.Adapter<DateAdapter.MyDateViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDateViewHolder =
            MyDateViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_date_filter, parent, false), listener)

    override fun onBindViewHolder(holder: MyDateViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class MyDateViewHolder(view: View, private val listener: DateListener) :
            RecyclerView.ViewHolder(view) {

        fun bind(item: Date) = with(itemView) {

            val dayOfMonthNumberFormat = SimpleDateFormat("dd")
            val dayOfWeekStringFormat = SimpleDateFormat("EEE")

            tv_filter_date_number.text = dayOfMonthNumberFormat.format(item.time)
            tv_filter_date_day.text = dayOfWeekStringFormat.format(item.time)

            setOnClickListener { listener(item) }
        }
    }
}
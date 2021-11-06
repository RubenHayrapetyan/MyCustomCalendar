package com.ruben.mycustomcalendar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ruben.mycustomcalendar.databinding.ItemCalendarDayNameBinding

class CalendarDayNameRecyclerAdapter : RecyclerView.Adapter<CalendarDayNameRecyclerAdapter.MyViewHolder>() {

    private val calendarDayNameList = mutableListOf<String>()

    fun setData(calendarDayNameList: List<String>) {
        this.calendarDayNameList.clear()
        this.calendarDayNameList.addAll(calendarDayNameList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCalendarDayNameBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(calendarDayNameList[position], position)
    }

    override fun getItemCount(): Int {
        return calendarDayNameList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemCalendarDayNameBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }

        fun bind(item: String, position: Int) {
            binding?.calendarDayName = item
            if (calendarDayNameList.lastIndex == position){
                binding?.isWeekend = true
            }
        }
    }
}
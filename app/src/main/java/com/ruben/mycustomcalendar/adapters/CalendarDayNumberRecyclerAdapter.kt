package com.ruben.mycustomcalendar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ruben.mycustomcalendar.databinding.ItemCalendarDayNumberBinding
import com.ruben.mycustomcalendar.models.CalendarDayNumberModel
import com.ruben.mycustomcalendar.util.getCurrentDay

class CalendarDayNumberRecyclerAdapter : RecyclerView.Adapter<CalendarDayNumberRecyclerAdapter.MyViewHolder>() {

    private val calendarDayNameArr = mutableListOf<CalendarDayNumberModel>()
    private var selectedPosition = 0
    private var isDefaultValueSet = false

    fun setData(calendarDayNumberModel: List<CalendarDayNumberModel>) {
        this.calendarDayNameArr.clear()
        this.calendarDayNameArr.addAll(calendarDayNumberModel)
        notifyDataSetChanged()
    }

    private var onItemClick : (dayId : Int) -> Unit = {}

    fun onItemClickCallBack(callback: (dayId : Int) -> Unit){
        onItemClick = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCalendarDayNumberBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(calendarDayNameArr[position], position)
    }

    override fun getItemCount(): Int {
        return calendarDayNameArr.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding: ItemCalendarDayNumberBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }

        fun bind(item: CalendarDayNumberModel, position: Int) {
            if (item.dayNumber == getCurrentDay() && !isDefaultValueSet) {
                item.isSelected = true
                isDefaultValueSet = true
            }

            if (item.isSelected){ selectedPosition = position }

            binding?.calendarDayNumberModel = item
            binding?.currentDay = getCurrentDay()
            binding?.llDay?.apply {
                setOnClickListener {
                    item.id?.let { onItemClick.invoke(it) }
                    calendarDayNameArr.forEach {
                        it.isSelected = false
                    }
                    calendarDayNameArr[position].isSelected = true
                    notifyItemChanged(selectedPosition)
                    notifyItemChanged(position)
                }
            }
        }
    }
}
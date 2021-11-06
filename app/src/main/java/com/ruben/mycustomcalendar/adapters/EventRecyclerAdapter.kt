package com.ruben.mycustomcalendar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ruben.mycustomcalendar.databinding.ItemEventBinding
import com.ruben.mycustomcalendar.models.Event

class EventRecyclerAdapter: RecyclerView.Adapter<EventRecyclerAdapter.MyViewHolder>() {

    private val eventArr = ArrayList<Event>()

    fun setData(eventList: List<Event>) {
        this.eventArr.clear()
        this.eventArr.addAll(eventList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEventBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(eventArr[position])
    }

    override fun getItemCount(): Int {
        return eventArr.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding: ItemEventBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }

        fun bind(item: Event) {
            binding?.event = item
        }
    }
}
package com.ruben.mycustomcalendar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruben.mycustomcalendar.adapters.CalendarDayNameRecyclerAdapter
import com.ruben.mycustomcalendar.adapters.CalendarDayNumberRecyclerAdapter
import com.ruben.mycustomcalendar.adapters.EventRecyclerAdapter
import com.ruben.mycustomcalendar.databinding.FragmentCalendarBinding
import com.ruben.mycustomcalendar.models.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding
    private val vm: CalendarViewModel by viewModels()
    private val eventRecyclerAdapter = EventRecyclerAdapter()
    private val calendarDayNameRecyclerAdapter = CalendarDayNameRecyclerAdapter()
    private val calendarDayNumberRecyclerAdapter = CalendarDayNumberRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCalendarRecycler()
        initEventsRecycler()
        setCalendarNumberData()
        setCalendarDayNameData()
        setEventsData()
    }

    private fun setCalendarNumberData(){
        calendarDayNumberRecyclerAdapter.setData(vm.retrieveCalendarNumberDataList())
    }

    private fun setCalendarDayNameData(){
        calendarDayNameRecyclerAdapter.setData(vm.retrieveCalendarDayNameDataList())
    }

    private fun setEventsData(){
        eventRecyclerAdapter.setData(vm.retrieveCurrentDayEvents())
    }

    private fun setEventsData(id: Int){
        eventRecyclerAdapter.setData(vm.retrieveCurrentDayEvents(id))
    }

    private fun initCalendarRecycler() {
        val concatAdapter = ConcatAdapter(calendarDayNameRecyclerAdapter, calendarDayNumberRecyclerAdapter)
        binding.rvCalendar.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 7, GridLayoutManager.VERTICAL, false)
            adapter = concatAdapter
            calendarDayNumberRecyclerAdapter.onItemClickCallBack { id ->
                setEventsData(id)
            }
        }
    }

    private fun initEventsRecycler() {
        binding.rvEvents.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = eventRecyclerAdapter
        }
    }
}
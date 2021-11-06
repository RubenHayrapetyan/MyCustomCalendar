package com.ruben.mycustomcalendar.ui

import com.ruben.mycustomcalendar.base.BaseViewModel
import com.ruben.mycustomcalendar.models.Event
import com.ruben.mycustomcalendar.util.getCurrentDay
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(private val repo: CalendarRepo) : BaseViewModel() {

    fun retrieveCalendarNumberDataList() = repo.getCalendarNumberDataList()

    fun retrieveCalendarDayNameDataList() = repo.getCalendarDayNameDataList()

    fun retrieveCurrentDayEvents(selectedId: Int): List<Event> {
        val eventList = mutableListOf<Event>()
        repo.getCalendarNumberDataList().forEach { calendarDayNumberModel ->
            if (selectedId == calendarDayNumberModel.id) {
                calendarDayNumberModel.eventList?.let {
                    eventList.addAll(it)
                }
            }
        }
        return eventList
    }

    fun retrieveCurrentDayEvents(): List<Event> {
        val eventList = mutableListOf<Event>()
        repo.getCalendarNumberDataList().forEach { calendarDayNumberModel ->
            if (getCurrentDay() == calendarDayNumberModel.dayNumber) {
                calendarDayNumberModel.eventList?.let {
                    eventList.addAll(it)
                }
            }
        }
        return eventList
    }
}
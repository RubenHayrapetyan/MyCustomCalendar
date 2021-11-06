package com.ruben.mycustomcalendar.models

data class CalendarDayNumberModel(
    val id: Int?,
    val dayNumber: Int?,
    var isSelected: Boolean,
    var isWeekend : Boolean?,
    val eventList: List<Event>?
)

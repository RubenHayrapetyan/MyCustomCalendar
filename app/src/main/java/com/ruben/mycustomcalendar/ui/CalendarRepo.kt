package com.ruben.mycustomcalendar.ui

import com.ruben.mycustomcalendar.data.calendarDayModel
import com.ruben.mycustomcalendar.data.calendarDayNameList
import com.ruben.mycustomcalendar.models.CalendarDayNumberModel

class CalendarRepo {

    fun getCalendarNumberDataList(): List<CalendarDayNumberModel> {
        return calendarDayModel
    }

    fun getCalendarDayNameDataList(): List<String> {
        return calendarDayNameList
    }
}
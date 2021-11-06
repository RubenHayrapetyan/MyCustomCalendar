package com.ruben.mycustomcalendar.data

import com.ruben.mycustomcalendar.models.CalendarDayNumberModel
import com.ruben.mycustomcalendar.models.Event

val calendarDayNameList = listOf(
    "Mon",
    "Tue",
    "Wed",
    "Thu",
    "Fri",
    "Sat",
    "Sun",
)

val eventList1 = listOf(
    Event(1, "Football", "10:00", "11:45"),
    Event(2, "Holiday", "14:20", "")
)

val eventList2 = listOf(
    Event(1, "Real Madrid vs Manchester City", "20:00", "22:45"),
)

val eventList3 = listOf(
    Event(1, "Birthday", "00:00", ""),
)

val eventList4 = listOf(
    Event(1, "Repair car", "10:00", "15:00"),
    Event(2, "Buy products for home", "18:00", ""),
)

val eventList5 = listOf(
    Event(1, "Go to work", "09:00", "19:00"),
    Event(2, "Meeting", "12:00", "12:45"),
    Event(3, "Break time", "13:00", "14:00"),
    Event(4, "Break time", "20:00", "23:59"),
)

val eventList6 = listOf(
    Event(1, "Go to work", "09:00", "19:00"),
    Event(2, "Meeting", "12:00", "12:45"),
    Event(3, "Break time", "13:00", "14:00"),
    Event(4, "Dance class", "20:00", "22:00"),
    Event(5, "Meet best friend", "22:30", ""),
)

val eventList7 = listOf(
    Event(1, "Go to work", "09:00", "19:00"),
)

val calendarDayModel = listOf(
    CalendarDayNumberModel(1, 1, false,false, eventList1),
    CalendarDayNumberModel(2, 2, false,false, eventList2),
    CalendarDayNumberModel(3, 3, false,false, eventList3),
    CalendarDayNumberModel(4, 4, false,false, eventList4),
    CalendarDayNumberModel(5, 5, false,false, eventList5),
    CalendarDayNumberModel(6, 6, false,false, eventList6),
    CalendarDayNumberModel(7, 7, false,true, eventList7),
    CalendarDayNumberModel(8, 8, false,false, null),
    CalendarDayNumberModel(9, 9, false,false, null),
    CalendarDayNumberModel(10, 10, false,false, null),
    CalendarDayNumberModel(11, 11, false,false, null),
    CalendarDayNumberModel(12, 12, false,false, null),
    CalendarDayNumberModel(13, 13, false,false, null),
    CalendarDayNumberModel(14, 14, false,true, null),
    CalendarDayNumberModel(15, 15, false,false, null),
    CalendarDayNumberModel(16, 16, false,false, null),
    CalendarDayNumberModel(17, 17, false,false, null),
    CalendarDayNumberModel(18, 18, false,false, null),
    CalendarDayNumberModel(19, 19, false,false, null),
    CalendarDayNumberModel(20, 20, false,false, null),
    CalendarDayNumberModel(21, 21, false,true, null),
    CalendarDayNumberModel(22, 22, false,false, null),
    CalendarDayNumberModel(23, 23, false,false, null),
    CalendarDayNumberModel(24, 24, false,false, null),
    CalendarDayNumberModel(25, 25, false,false, null),
    CalendarDayNumberModel(26, 26, false,false, null),
    CalendarDayNumberModel(27, 27, false,false, null),
    CalendarDayNumberModel(28, 28, false,true, null),
    CalendarDayNumberModel(28, 29, false,false, null),
    CalendarDayNumberModel(28, 30, false,false, null),
)


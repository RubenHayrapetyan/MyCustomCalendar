package com.ruben.mycustomcalendar.util

import java.util.*

fun getCurrentDay(): Int {
    val calendar = Calendar.getInstance()
    return calendar.get(Calendar.DAY_OF_MONTH)
}
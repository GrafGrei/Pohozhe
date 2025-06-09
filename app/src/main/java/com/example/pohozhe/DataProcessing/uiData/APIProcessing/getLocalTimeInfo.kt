package com.example.pohozhe.DataProcessing.uiData.APIProcessing

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import com.example.pohozhe.dataclasses.LocalTimeInfo

fun getCurrentLocalTimeInfo(): LocalTimeInfo {
    val now = ZonedDateTime.now()
    val locale = Locale.getDefault()

    val time = now.format(DateTimeFormatter.ofPattern("HH:mm", locale))
    val date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd", locale))
    val dayOfWeek = now.format(DateTimeFormatter.ofPattern("E", locale))
    val timeZone = TimeZone.getDefault().id

    return LocalTimeInfo(
        time = time,
        date = date,
        dayOfWeek = dayOfWeek,
        timeZone = timeZone
    )
}

package com.example.pohozhe.DataProcessing.uiData.APIProcessing.requests

import TimeSeries
import WeatherResponse
import com.example.pohozhe.R
import com.example.pohozhe.dataclasses.DayWhether
import com.example.pohozhe.dataclasses.HourlyWhether
import com.example.pohozhe.dataclasses.WhetherData
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.ZoneId
import java.time.Instant
import java.util.Locale
import com.example.pohozhe.dataclasses.WetherState
import com.example.pohozhe.dataclasses.Wind
import retrofit2.Call
import java.time.format.TextStyle


fun FormatWhetherData(data: WeatherResponse): WhetherData {
    val zoneId = ZoneId.systemDefault()
    var timeseries = data.properties.timeseries

    val now = ZonedDateTime.now(zoneId)
    val today = now.toLocalDate()

    val hourlyList = mutableListOf<HourlyWhether>()
    val tempPerDay = mutableMapOf<String, Pair<Int, Int>>() // "Пн" -> (max, min)

    var firstEntry: TimeSeries? = null

    for (entry in timeseries) {
        val timeUtc = Instant.parse(entry.time)
        val timeLocal = timeUtc.atZone(zoneId)

        if (timeLocal.toLocalDate() != today || timeLocal.isBefore(now)) continue

        val details = entry.data.instant.details
        val temp = details.air_temperature?.toInt() ?: 0
        val humidity = details.relative_humidity?.toInt() ?: 0
        val windSpeed = details.wind_speed?.toInt() ?: 0
        val windDir = details.wind_from_direction?: 0.0
        val uv = details.ultraviolet_index_clear_sky?.toInt() ?: 0
        val pressure = details.air_pressure_at_sea_level?.toInt() ?: 0
        val rain = entry.data.next_1_hours?.details?.precipitation_amount?.toFloat() ?: 0f

        if (firstEntry == null) {
            firstEntry = entry
        }

        val hourFormatted = timeLocal.format(DateTimeFormatter.ofPattern("HH:mm"))
        hourlyList.add(
            HourlyWhether(
                ico = R.drawable.hourly_forecast_ico,
                temp = temp,
                time = hourFormatted
            )
        )

        val dayKey = timeLocal.format(DateTimeFormatter.ofPattern("E", Locale.getDefault())) // "Пн", "Mon", etc.
        val (max, min) = tempPerDay[dayKey] ?: (temp to temp)
        tempPerDay[dayKey] = maxOf(temp, max) to minOf(temp, min)
    }

    val dayList = tempPerDay.map { (dayStr, temps) ->
        DayWhether(
            maxTemp = temps.first,
            minTemp = temps.second,
            ico = R.drawable.hourly_forecast_ico,
            date = dayStr
        )
    }.toMutableList()

    if (dayList.size < 5) {
        val existingDays = dayList.map { it.date }.toSet()
        var dayToAdd = now.dayOfWeek

        while (dayList.size < 5) {
            dayToAdd = dayToAdd.plus(1)
            val shortDayName = dayToAdd.getDisplayName(TextStyle.SHORT, Locale.getDefault())

            if (shortDayName !in existingDays) {
                dayList.add(
                    DayWhether(
                        maxTemp = 0,
                        minTemp = 0,
                        ico = R.drawable.hourly_forecast_ico,
                        date = shortDayName
                    )
                )
            }
        }
    }


    return WhetherData(
        state = WetherState(
            Text = "Partly Cloudy",
            Ico = R.drawable.hourly_forecast_ico
        ),
        temp = firstEntry?.data?.instant?.details?.air_temperature?.toInt() ?: 0,
        hours = hourlyList,
        days = dayList,
        huminidy = firstEntry?.data?.instant?.details?.relative_humidity?.toInt() ?: 0,
        rayny = firstEntry?.data?.next_1_hours?.details?.precipitation_amount?.toFloat() ?: 0f,
        wind = Wind(
            speed = firstEntry?.data?.instant?.details?.wind_speed?.toInt() ?: 0,
            direction = firstEntry?.data?.instant?.details?.wind_from_direction ?: 0.0
        ),
        uv_index = firstEntry?.data?.instant?.details?.ultraviolet_index_clear_sky?.toInt() ?: 0,
        pressure = firstEntry?.data?.instant?.details?.air_pressure_at_sea_level?.toInt() ?: 0
    )
}
package com.example.pohozhe.dataclasses


data class WhetherData(
    val location: String,
    val locationCords: Cordinates,
    val state: WetherState,
    val temp: Int,
    val hours: List<HourlyWhether>,
    var days: List<DayWhether>,
    val huminidy: Int,
    val rayny: Float,
    val wind: Wind,
    val uv_index: Int,
    val pressure: String
)

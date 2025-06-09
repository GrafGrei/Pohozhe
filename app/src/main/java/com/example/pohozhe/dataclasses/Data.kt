data class Data(
    val instant: Instant,
    val next_12_hours: Forecast?,
    val next_1_hours: Forecast?,
    val next_6_hours: Forecast?
)
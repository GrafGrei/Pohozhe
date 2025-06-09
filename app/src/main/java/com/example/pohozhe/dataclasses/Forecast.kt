data class Forecast(
    val summary: Summary,
    val details: WeatherDetails? = null
)
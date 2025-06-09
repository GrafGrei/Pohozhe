package com.example.pohozhe.DataProcessing.uiData.APIProcessing.requests.Interfaces

import WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weatherapi/locationforecast/2.0/complete")
    suspend fun getWeatherForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): WeatherResponse
}

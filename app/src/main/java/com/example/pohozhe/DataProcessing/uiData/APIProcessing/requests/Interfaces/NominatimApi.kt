package com.example.pohozhe.DataProcessing.uiData.APIProcessing.requests.Interfaces

import com.example.pohozhe.dataclasses.Address
import retrofit2.http.GET
import retrofit2.http.Query

data class GetAddressResponce(
    val address: Address?
)

interface NominatimApi {
    @GET("reverse")
    suspend fun getLocationName(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("format") format: String = "json",
        @Query("accept-language") language: String
    ): GetAddressResponce
}
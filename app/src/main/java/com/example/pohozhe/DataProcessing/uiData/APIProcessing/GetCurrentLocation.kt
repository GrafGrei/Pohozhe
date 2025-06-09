package com.example.pohozhe.DataProcessing.uiData.APIProcessing

import androidx.compose.runtime.Composable
import com.example.pohozhe.DataProcessing.uiData.APIProcessing.requests.Clients.NominatimClient
import com.example.pohozhe.MainViewModel
import com.example.pohozhe.dataclasses.Location
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.example.pohozhe.dataclasses.Coordinates


@Composable
fun GetCurrentLocation(
    viewModel: MainViewModel
){
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        println("LaunchedEffect triggered")
        val coordinates = try {
            getCurrentCoordinates(context = context, timeoutMillis = 7000L)
        } catch (e: Exception) {
            null
        }
        println(coordinates)

        coordinates?.let {
            val lat = it.lat
            val lon = it.lon
            val result = NominatimClient.api.getLocationName(
                lat = lat,
                lon = lon,
                language = "EN"
            )
            val address = result.address
            val formatted = listOfNotNull(
                address?.city ?: address?.town ?: address?.village,
                address?.road
            ).joinToString(", ")
            viewModel.currentLocation = Location(
                coordinates = Coordinates(lat = lat ,lon = lon),
                name = formatted
            )
        }
    }
}
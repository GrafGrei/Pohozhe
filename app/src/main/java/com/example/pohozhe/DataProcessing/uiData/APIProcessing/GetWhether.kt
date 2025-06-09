package com.example.pohozhe.DataProcessing.uiData.APIProcessing

import androidx.lifecycle.viewModelScope
import com.example.pohozhe.DataProcessing.uiData.APIProcessing.requests.Clients.WhetherClient
import com.example.pohozhe.MainViewModel
import com.example.pohozhe.DataProcessing.uiData.APIProcessing.requests.FormatWhetherData
import kotlinx.coroutines.launch

fun GetWhether(
    viewModel: MainViewModel
) {
    val location = viewModel.currentLocation
    val coordinates = location!!.coordinates
    val lat = coordinates.lat
    val lon = coordinates.lon

    viewModel.viewModelScope.launch {
        try {
            val response = WhetherClient.instance.getWeatherForecast(lat, lon)
            val formatted = FormatWhetherData(response)
            viewModel.whetherData = formatted
            println(viewModel.whetherData.toString())
        } catch (e: Exception) {
            e.printStackTrace()
            println(e)
        }
    }
}

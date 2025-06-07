package com.example.pohozhe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.pohozhe.dataclasses.Coordinates
import com.example.pohozhe.dataclasses.DayWhether
import com.example.pohozhe.dataclasses.HourlyWhether
import com.example.pohozhe.dataclasses.Location
import com.example.pohozhe.dataclasses.LocationCurrentWhetherState
import com.example.pohozhe.dataclasses.WetherState
import com.example.pohozhe.dataclasses.WhetherData
import com.example.pohozhe.dataclasses.Wind
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.pohozhe.dataclasses.PaddingState


class MainViewModel: ViewModel() {

    var paddingState by mutableStateOf<PaddingState?>(null)

    var whetherData by mutableStateOf<WhetherData?>(null)

    var currentLocation by mutableStateOf<Location?>(null)

    var currentLocationWetherState by mutableStateOf<LocationCurrentWhetherState?>(null)

    var locationsList by mutableStateOf<List<Pair<Location, LocationCurrentWhetherState?>>?>(null)


    init {
        loadData()
    }


    fun loadData() {
        whetherData =  WhetherData(
            state =  WetherState("Хмарно", R.drawable.cloudy_wether_ico),
            temp = 19,
            hours = List(13){
                HourlyWhether(R.drawable.cloudy_wether_ico,18, "now")
            },
            days = List(5) {
                DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today)
            },
        huminidy = 12,
            rayny = 0.3F,
            wind = Wind(10, 122.2),
            uv_index = 5,
            pressure = 1222
        )
        currentLocation = Location(
            name = "HUILANDIA",
            coordinates = Coordinates(12.2412, 12.242)
        )
        currentLocationWetherState = LocationCurrentWhetherState(
            ico = R.drawable.cloudy_wether_ico,
            temp = 12
        )
        locationsList = listOf(
            Pair(Location("Talne", Coordinates(50.45, 30.52)), null),
            Pair(Location("Talne", Coordinates(50.45, 30.52)), LocationCurrentWhetherState(R.drawable.cloudy_wether_ico, 124))
        )
    }
}

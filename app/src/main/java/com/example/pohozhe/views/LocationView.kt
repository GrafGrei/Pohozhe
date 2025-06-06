package com.example.pohozhe.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pohozhe.R
import com.example.pohozhe.UI.LocationListItem
import com.example.pohozhe.UI.SearchButton
import com.example.pohozhe.UI.SecondaryToolBar
import com.example.pohozhe.dataclasses.Coordinates
import com.example.pohozhe.dataclasses.DayWhether
import com.example.pohozhe.dataclasses.HourlyWhether
import com.example.pohozhe.dataclasses.Location
import com.example.pohozhe.dataclasses.LocationItem
import com.example.pohozhe.dataclasses.WetherState
import com.example.pohozhe.dataclasses.WhetherData
import com.example.pohozhe.dataclasses.Wind
import com.example.pohozhe.ui.theme.PohozheTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun LocationView(
    modifier: Modifier = Modifier,
    statusPading: Int,
    returnFunction: ()-> Unit,
    currentLocation: LocationItem? = null,
    locationsList: Array<LocationItem>? = null
) {
    Box(
        modifier = Modifier.background(Color(0xFF131313))
    ){
        Scaffold(
            containerColor = Color(0xFF131313),
            modifier = modifier
                .padding(top = 6.dp)
                .padding(top = statusPading.dp),
            topBar = {
                SecondaryToolBar(
                    modifier = Modifier,
                    label = stringResource(R.string.locations),
                    returnFunction = returnFunction
                )
            },
            bottomBar = {
                Column(

                ) {
                    SearchButton()
                }
            }
        ) { innerPading ->
            Column(
                Modifier.padding(innerPading)
            ) {
                if (currentLocation != null) {
                    Column(
                        modifier = Modifier
                            .padding(top = 30.dp)
                    ) {
                        Row(

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.curent_location_ico),
                                contentDescription = "image description",
                                contentScale = ContentScale.None,
                                modifier = Modifier
                                    .width(22.dp)
                                    .height(22.dp)
                            )
                            Text(
                                text = "Поточне місце",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.geologica)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFFFFFFF),
                                )
                            )
                        }
                        Column(

                        ) {
                            LocationListItem(
                                modifier = Modifier,
                                location = currentLocation
                            )
                        }
                    }
                }
                if (locationsList != null) {
                    Column(

                    ) {
                        Column(

                        ) {
                            for (item in locationsList) {
                                LocationListItem(
                                    modifier = Modifier,
                                    location = item
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewLocationView(){
    PohozheTheme {
        LocationView(
            modifier = Modifier,
            statusPading =40,
            currentLocation = LocationItem(
                Location(
                    "Talne",
                    Coordinates(
                        12.231,
                        21.213
                    )
                ),
                WhetherData(
                    state =  WetherState("Хмарно", R.drawable.cloudy_wether_ico),
                    temp = 19,
                    hours = listOf(
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                    ),
                    days = listOf(
                        DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                        DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                        DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                        DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                        DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today)
                    ),
                    huminidy = 12,
                    rayny = 0.3F,
                    wind = Wind(10, 122.2),
                    uv_index = 5,
                    pressure = 1222
                )
            ),
            locationsList = null,
            returnFunction = {}
        )
    }
}
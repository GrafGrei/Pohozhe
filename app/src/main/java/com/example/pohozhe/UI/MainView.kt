package com.example.pohozhe.UI

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pohozhe.dataclasses.WhetherData
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pohozhe.R
import com.example.pohozhe.dataclasses.DayWhether
import com.example.pohozhe.dataclasses.HourlyWhether
import com.example.pohozhe.dataclasses.WetherState
import com.example.pohozhe.dataclasses.Wind
import com.example.pohozhe.ui.theme.PohozheTheme
import com.skydoves.cloudy.cloudy



@Composable
fun MainView(modifier: Modifier = Modifier,statusPadding: Int, bottomPadding: Int, whetherData: WhetherData , currentLocation: String){
    Scaffold(
        modifier = modifier
            .fillMaxWidth(),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((statusPadding + 68).dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                ToolBar(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .offset(y = statusPadding.dp),
                    curent_location = currentLocation
                )
            }
        }
    ){
        inerPading ->
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter,
        ){
            MainSlide(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                whetherData = whetherData,
                statusPadding = inerPading,
                bottomPadding = bottomPadding
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((statusPadding + 58).dp)
            ) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color(0x20565656))
                )
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .cloudy(radius = 15)
                ){
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(bottomPadding.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color(0x20565656))
                )
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .cloudy(radius = 15)
                ){
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewMainView() {
    PohozheTheme {
        MainView(
            whetherData =  WhetherData(
                WetherState("Хмарно", R.drawable.cloudy_wether_ico),
                19,
                listOf(
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
                listOf(
                    DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                    DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                    DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                    DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                    DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today)
                ),
                12,
                0.3F,
                Wind(10, 122.2),
                5,
                1222
            ),
            currentLocation = "Talne",
            statusPadding = 68,
            bottomPadding = 40
        )
    }
}
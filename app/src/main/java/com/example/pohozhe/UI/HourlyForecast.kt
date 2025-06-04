package com.example.pohozhe.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pohozhe.dataclasses.HourlyWhether
import com.example.pohozhe.R
import com.skydoves.cloudy.cloudy

@Composable
fun HourlyForecast(modifier: Modifier = Modifier, hours: List<HourlyWhether>) {
    Column (
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .width(400.dp)
            .height(190.dp)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .padding(start = 20.dp, top = 20.dp, bottom = 25.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp)
                .padding(end = 20.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.hourly_forecast_ico),
                contentDescription = null,
            )
            Text(
                text = stringResource(R.string.hourlyforecast),
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 22.sp,
                    fontFamily = FontFamily(Font(R.font.geologica)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.tertiary,
                ),
                modifier =Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(end = 20.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .horizontalScroll(state = rememberScrollState())
        ){
            for (hour in hours) {
                Column (
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(57.dp)
                        .padding(top = 20.dp, end = 3.dp)
                ) {
                    Text(
                        text = hour.temp.toString()+"°",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 14.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight(500),
                            color = MaterialTheme.colorScheme.tertiary,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Image(
                        painter = painterResource(id = hour.ico),
                        contentDescription = "image description",
                        modifier = Modifier
                            .padding(vertical = 13.dp)
                            .width(32.dp)
                            .height(32.dp)
                    )
                    Text(
                        text = hour.time,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 14.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight(500),
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewHourlyForecast() {
//    PohozheTheme {
//        HourlyForecast(
//            hours = listOf(
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//                HourlyWhether(R.drawable.cloudy_wether_ico, "12", R.string.now),
//            )
//        )
//    }
//}
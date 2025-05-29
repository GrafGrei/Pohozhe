package com.example.pohozhe.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pohozhe.dataclasses.DayWhether
import com.example.pohozhe.R
import com.example.pohozhe.ui.theme.PohozheTheme

@Composable
fun DaylyForecast(modifier: Modifier = Modifier, days: List<DayWhether>){
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .width(400.dp)
            .height(217.dp)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 25.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.days_forecast_ico),
                contentDescription = "image description",
                modifier = Modifier
                    .padding(0.6875.dp)
                    .width(22.dp)
                    .height(22.dp)
            )
            Text(
                text = stringResource(R.string.daysforecast),
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
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            repeat(5){
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(57.dp)
                ) {
                    Text(
                        text = days[it].maxTemp+"°",
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
                            .padding(top = 9.dp, bottom = 5.dp)
                            .height(20.dp)

                    )
                    Text(
                        text = days[it].minTemp+"°",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 14.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight(500),
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                    )
                    Image(
                        painter = painterResource(id = days[it].ico),
                        contentDescription = "image description",
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .width(32.dp)
                            .height(32.dp)
                    )
                    Text(
                        text = stringResource(days[it].date),
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight(500),
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(18.dp)
                    )
                }
                if (4>it){Spacer(Modifier
                    .fillMaxHeight()
                    .weight(1f))}
            }
        }
    }
}

@Preview(locale = "UK")
@Composable
fun PreviewDaylyForecast(){
    PohozheTheme {
        DaylyForecast(
            days = listOf(
                DayWhether("10", "12", R.drawable.cloudy_wether_ico, R.string.today),
                DayWhether("10", "12", R.drawable.cloudy_wether_ico, R.string.today),
                DayWhether("10", "12", R.drawable.cloudy_wether_ico, R.string.today),
                DayWhether("10", "12", R.drawable.cloudy_wether_ico, R.string.today),
                DayWhether("10", "12", R.drawable.cloudy_wether_ico, R.string.today),
            )
        )
    }
}
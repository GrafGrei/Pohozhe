package com.example.pohozhe.UI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pohozhe.dataclasses.WetherState
import com.example.pohozhe.dataclasses.WhetherData
import com.example.pohozhe.ui.theme.PohozheTheme
import com.example.pohozhe.R
import com.example.pohozhe.dataclasses.DayWhether
import com.example.pohozhe.dataclasses.HourlyWhether
import com.example.pohozhe.dataclasses.Wind


@Composable
fun MainSlide(modifier: Modifier = Modifier,bottomPadding: Int, statusPadding: PaddingValues, whetherData: WhetherData){
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
            .padding(bottom = bottomPadding.dp)
            .padding(statusPadding),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ){
            CurrenWetherBlock(Modifier.weight(1f), whetherData.state)
            CurrentTemperatureBlock(Modifier.weight(1f), whetherData.temp)
        }
        HourlyForecast(
            modifier = Modifier,
            whetherData.hours
        )
        DaylyForecast(
            modifier = Modifier,
            whetherData.days
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WindBlock(
                modifier = Modifier,
                whetherData.wind
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                HumidityBlock(
                    modifier = Modifier,
                    whetherData.huminidy
                )
                PrecipitationBlock(
                    modifier = Modifier,
                    whetherData.rayny
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PressureBlock(
                modifier = Modifier
                    .weight(1f),
                whetherData.pressure
            )
            UVIndexBlock(
                modifier = Modifier
                    .weight(1f),
                whetherData.uv_index
            )
        }
    }
}

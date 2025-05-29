package com.example.pohozhe.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pohozhe.R
import com.example.pohozhe.dataclasses.WetherState
import com.example.pohozhe.ui.theme.PohozheTheme


@Composable
fun TopWhetherBlock(modifier: Modifier = Modifier, state: WetherState, current_temperature: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        CurrenWetherBlock(Modifier.weight(1f), state)
        CurrentTemperatureBlock(Modifier.weight(1f), current_temperature)
    }
}




@Preview(locale = "EN", widthDp = 400)
@Composable
fun PreviewTopWhetherBlock() {
    PohozheTheme {
        TopWhetherBlock(
            state = WetherState(
                Text = stringResource(R.string.cloudy),
                Ico = R.drawable.cloudy_wether_ico
            ),
            current_temperature = 20
        )
    }
}

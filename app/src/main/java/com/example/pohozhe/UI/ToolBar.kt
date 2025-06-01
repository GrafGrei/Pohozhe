package com.example.pohozhe.UI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pohozhe.ui.theme.PohozheTheme

@Composable
fun ToolBar(modifier: Modifier = Modifier, curent_location:String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.height(48.dp)
    ) {
        ChangeLocationButton() {

        }
        CurrentLocationText(Modifier, curent_location)
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        SettingsButton()
    }
}

@Preview()
@Composable
fun PreviewToolBar(){
    PohozheTheme {
        ToolBar(curent_location = "Тальне")
    }
}
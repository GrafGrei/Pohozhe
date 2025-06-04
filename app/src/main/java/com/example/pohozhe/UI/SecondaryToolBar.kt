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
fun SecondaryToolBar(
    modifier: Modifier = Modifier,
    label: String,
    returnFunction: () -> Unit
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.height(48.dp)
    ) {
        ReturnButton(
            onClickFunction = returnFunction
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        ViewLabel(label = label)
    }
}

@Preview()
@Composable
fun PreviewSecondaryToolBar(){
    PohozheTheme {
        SecondaryToolBar(
            label= "test",
            returnFunction = {}
        )
    }
}
package com.example.pohozhe.ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pohozhe.R
import com.example.pohozhe.ui.theme.PohozheTheme

@Composable
fun ChangeLocationButton(modifier: Modifier = Modifier){
    IconButton(
        onClick = {},
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .width(48.dp)
            .fillMaxHeight()
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .padding(13.dp),
    ) {
        Icon(
            painter = painterResource(R.drawable.location_ico),
            contentDescription = null,
            modifier = Modifier
                .width(22.dp)
                .height(22.dp),
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Preview(widthDp = 48, heightDp = 48)
@Composable
fun PreviewChangeLocationButton(){
    PohozheTheme {
        ChangeLocationButton()
    }
}




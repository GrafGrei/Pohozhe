package com.example.pohozhe.ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pohozhe.ui.theme.PohozheTheme
import com.example.pohozhe.R



@Composable
fun CurrentLocationText(modifier: Modifier = Modifier, current_location:String){
    Text(
        text = current_location,
        style = TextStyle(
            fontSize = 24.sp,
            lineHeight = 14.sp,
            fontFamily = FontFamily(Font(R.font.geologica)),
            color = MaterialTheme.colorScheme.tertiary,
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            textAlign = TextAlign.Center,
        ),
        modifier = modifier
            .padding(start = 8.dp)
            .fillMaxHeight()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .wrapContentHeight(Alignment.CenterVertically)
            .padding(horizontal = 17.dp)
    )
}


@Preview(heightDp = 48)
@Composable
fun PreviewCurrentLocationText(){
    PohozheTheme {
        CurrentLocationText(current_location = "Тальне")
    }
}
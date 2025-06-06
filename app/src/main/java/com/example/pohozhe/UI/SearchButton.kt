package com.example.pohozhe.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pohozhe.R
import com.example.pohozhe.ui.theme.PohozheTheme

@Composable
fun SearchButton(
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier =  modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 9.dp)
            )
            .fillMaxWidth()
            .height(44.dp)
            .background(color = Color(0x66616161), shape = RoundedCornerShape(size = 9.dp))
            .padding(11.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.search_ico),
            contentDescription = null,
            contentScale = ContentScale.None,
            modifier = Modifier
                .width(22.dp)
                .height(22.dp)
        )
        Text(
            text = "Додати нове місце",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 14.sp,
                fontFamily = FontFamily(Font(R.font.geologica)),
                fontWeight = FontWeight(500),
                color = Color(0xA8FFFFFF),
                textAlign = TextAlign.Center,
            )
        )
        Spacer(
            modifier = Modifier
                .width(22.dp)
        )
    }
}


@Preview
@Composable
fun PreviewSearchButton(){
    PohozheTheme {
        SearchButton()
    }
}
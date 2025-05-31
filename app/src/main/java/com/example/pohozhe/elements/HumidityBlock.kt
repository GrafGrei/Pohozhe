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
import com.example.pohozhe.R
import com.example.pohozhe.ui.theme.PohozheTheme

@Composable
fun HumidityBlock(modifier: Modifier=Modifier, currentHumidity: Int){
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .height(113.dp)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.hyminidy_ico),
                contentDescription = "image description",
                modifier = Modifier
                    .width(22.dp)
                    .height(22.dp)
            )
            Text(
                text = stringResource(R.string.humidity),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 14.sp,
                    fontFamily = FontFamily(Font(R.font.geologica)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.tertiary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = currentHumidity.toString(),
                style = TextStyle(
                    fontSize = 36.sp,
                    lineHeight = 14.sp,
                    fontFamily = FontFamily(Font(R.font.geologica)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.tertiary,
                ),
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                text = "%",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 14.sp,
                    fontFamily = FontFamily(Font(R.font.geologica)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onTertiary,
                    textAlign = TextAlign.Right,
                ),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(50.dp)
                    .fillMaxHeight()
            )
        }
    }
}



@Preview(widthDp = 190)
@Composable
fun PreviewHumidityBlock(){
    PohozheTheme {
        HumidityBlock(
            currentHumidity = 100
        )
    }
}

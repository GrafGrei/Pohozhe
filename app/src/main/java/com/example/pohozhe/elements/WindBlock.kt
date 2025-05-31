package com.example.pohozhe.elements

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.draw.rotate
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
import com.example.pohozhe.dataclasses.Wind
import com.example.pohozhe.ui.theme.PohozheTheme
import com.example.pohozhe.R


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun WindBlock(modifier: Modifier = Modifier, windData: Wind) {
    Column (
        verticalArrangement = Arrangement.spacedBy(0.dp,Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .width(190.dp)
            .height(246.dp)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .padding(top = 20.dp, bottom = 27.dp, start = 20.dp, end = 20.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.wind_ico),
                contentDescription = "image description",
                modifier = Modifier
                    .width(22.dp)
                    .height(22.dp)
            )
            Text(
                text = stringResource(R.string.wind),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 14.sp,
                    fontFamily = FontFamily(Font(R.font.geologica)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.tertiary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
        Spacer(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1F),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.wind_direction_container),
                contentDescription = "image description",
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.south),
                        modifier = Modifier,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.north),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 11.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.east),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 11.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.west),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
            Column(
                modifier = Modifier
                    .width(76.dp)
                    .height(66.dp)
            ) {
                Text(
                    text = windData.speed.toString(),
                    style = TextStyle(
                        fontSize = 36.sp,
                        lineHeight = 36.sp,
                        fontFamily = FontFamily(Font(R.font.geologica)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onTertiary,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .height(46.dp)
                        .fillMaxWidth()
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = stringResource(R.string.ms),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 14.sp,
                        fontFamily = FontFamily(Font(R.font.geologica)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onTertiary,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth()
                )
            }
            Image(
                painter = painterResource(id = R.drawable.wind_direction),
                contentDescription = "image description",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .rotate(windData.direction.toFloat())
            )
        }
    }
}


@Preview(locale = "UK")
@Composable
fun PreviewWindBlock(){
    PohozheTheme {
        WindBlock(
           windData = Wind(5, 23.1)
        )
    }
}
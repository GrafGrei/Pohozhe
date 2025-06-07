package com.example.pohozhe.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pohozhe.R
import com.example.pohozhe.dataclasses.Location
import com.example.pohozhe.dataclasses.LocationCurrentWhetherState
import com.skydoves.cloudy.cloudy


@Composable
fun LocationListItem (
    modifier: Modifier = Modifier,
    location: Location,
    whetherData: LocationCurrentWhetherState?
){
    Box(
        modifier = modifier
            .height(104.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
    ){
        Image(
            painter = painterResource(R.drawable.test_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .cloudy(radius = 57)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                8.dp,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            if (whetherData == null){
                Box(
                    modifier =  Modifier
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            shape = RoundedCornerShape(size = 9.dp)
                        )
                        .width(74.dp)
                        .height(74.dp)
                        .background(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(size = 9.dp)
                        )
                        .padding(
                            start = 15.dp,
                            top = 15.dp,
                            end = 15.dp,
                            bottom = 15.dp
                        )
                ){
                    Text(
                        text = "?",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 41.sp,
                            lineHeight = 5.05.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight(900),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
                Box(
                    modifier =  Modifier
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            shape = RoundedCornerShape(size = 9.dp)
                        )
                        .height(74.dp)
                        .background(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(size = 9.dp)
                        )
                        .padding(
                            start = 15.dp,
                            top = 15.dp,
                            end = 15.dp,
                            bottom = 15.dp
                        )
                ){
                    Text(
                        text = "?",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 41.sp,
                            lineHeight = 5.05.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight(900),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            } else{
                Box(
                    modifier =  Modifier
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            shape = RoundedCornerShape(size = 9.dp)
                        )
                        .width(74.dp)
                        .height(74.dp)
                        .background(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(size = 9.dp)
                        )
                        .padding(
                            start = 15.dp,
                            top = 15.dp,
                            end = 15.dp,
                            bottom = 15.dp
                        )
                ){
                    Image(
                        painter = painterResource(id = whetherData.ico),
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1F)
                    )
                }
                Box(
                    modifier =  Modifier
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            shape = RoundedCornerShape(size = 9.dp)
                        )
                        .height(74.dp)
                        .background(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(size = 9.dp)
                        )
                        .padding(
                            start = 15.dp,
                            top = 15.dp,
                            end = 15.dp,
                            bottom = 15.dp
                        )
                ){
                    Text(
                        text = whetherData.temp.toString() + "°",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 41.sp,
                            lineHeight = 5.05.sp,
                            fontFamily = FontFamily(Font(R.font.geologica)),
                            fontWeight = FontWeight(900),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Box(
                modifier =  Modifier
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        shape = RoundedCornerShape(size = 9.dp)
                    )
                    .height(74.dp)
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(size = 9.dp)
                    )
                    .padding(
                        start = 15.dp,
                        top = 15.dp,
                        end = 15.dp,
                        bottom = 15.dp
                    ),
                contentAlignment = Alignment.Center

            ){
                Text(
                    text = location.name,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 5.sp,
                        fontFamily = FontFamily(Font(R.font.geologica)),
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    }
}

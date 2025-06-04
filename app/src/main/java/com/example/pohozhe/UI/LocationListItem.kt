package com.example.pohozhe.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pohozhe.R
import com.example.pohozhe.dataclasses.Location
import com.example.pohozhe.dataclasses.LocationItem
import com.example.pohozhe.ui.theme.PohozheTheme
import com.skydoves.cloudy.cloudy


@Composable
fun LocationListItem (
    modifier: Modifier = Modifier,
    location: LocationItem
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
//                Image(
//
//                )
            }
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
//                Text(
//
//                )
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
                    )

            ){
//                Text(
//
//                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewLocationListItem(){
    PohozheTheme {
        LocationListItem(

        )
    }
}
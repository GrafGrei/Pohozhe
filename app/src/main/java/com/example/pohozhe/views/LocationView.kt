package com.example.pohozhe.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pohozhe.R
import com.example.pohozhe.UI.LocationListItem
import com.example.pohozhe.UI.SearchButton
import com.example.pohozhe.UI.SecondaryToolBar
import com.example.pohozhe.ui.theme.PohozheTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pohozhe.MainViewModel
import com.example.pohozhe.dataclasses.LocationCurrentWhetherState
import com.example.pohozhe.dataclasses.PaddingState

@Composable
fun LocationView(
    modifier: Modifier = Modifier,
    returnFunction: ()-> Unit,
    SearchButtonClick: ()-> Unit,
    viewModel: MainViewModel = viewModel()
) {
    val currentLocation = viewModel.currentLocation
    val currentLocationWhetherState = viewModel.currentLocationWetherState
    val locations = viewModel.locationsList
    val paddingState = viewModel.paddingState?: PaddingState(0,0)
    Box(
        modifier = Modifier.background(Color(0xFF131313))
    ){
        Scaffold(
            containerColor = Color(0xFF131313),
            modifier = modifier
                .padding(top = 6.dp)
                .padding(top = paddingState.top.dp),
            topBar = {
                SecondaryToolBar(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    label = stringResource(R.string.locations),
                    returnFunction = returnFunction
                )
            },
            bottomBar = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .border(width = 1.dp, color = Color(0x1700010F), shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                        .background(color = Color(0x663D3D3D), shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                        .padding(bottom = paddingState.bottom.dp)
                        .padding(horizontal = 15.dp)
                        .padding(top = 15.dp)
                ) {
                    SearchButton(
                        modifier = Modifier
                            .clickable(onClick = SearchButtonClick)
                    )
                }
            }
        ) { innerPading ->
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =  Modifier
                    .padding(innerPading)
                    .padding(horizontal = 20.dp)
            ) {
                if (currentLocation != null) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(top = 30.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.curent_location_ico),
                                contentDescription = "image description",
                                contentScale = ContentScale.None,
                                modifier = Modifier
                                    .width(22.dp)
                                    .height(22.dp)
                            )
                            Text(
                                text = "Поточне місце",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.geologica)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFFFFFFF),
                                )
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            LocationListItem(
                                modifier = Modifier,
                                location = currentLocation,
                                whetherData = currentLocationWhetherState
                            )
                        }
                    }
                }
                if (locations != null) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.locations_ico),
                                contentDescription = "image description",
                                contentScale = ContentScale.None,
                                modifier = Modifier
                                    .width(22.dp)
                                    .height(22.dp)
                            )
                            Text(
                                text = "Збережені місця",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.geologica)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFFFFFFF),
                                )
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            for (item in locations) {
                                LocationListItem(
                                    modifier = Modifier,
                                    location = item.first,
                                    whetherData = item.second
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewLocationView(){
    PohozheTheme {
        LocationView(
            modifier = Modifier,
            returnFunction = {},
            SearchButtonClick= {}
        )
    }
}
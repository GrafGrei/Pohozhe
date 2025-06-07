package com.example.pohozhe.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pohozhe.MainViewModel
import com.example.pohozhe.R
import com.example.pohozhe.UI.MainSlide
import com.example.pohozhe.UI.ToolBar
import com.example.pohozhe.dataclasses.DayWhether
import com.example.pohozhe.dataclasses.HourlyWhether
import com.example.pohozhe.dataclasses.PaddingState
import com.example.pohozhe.dataclasses.WetherState
import com.example.pohozhe.dataclasses.WhetherData
import com.example.pohozhe.dataclasses.Wind
import com.example.pohozhe.ui.theme.PohozheTheme
import com.skydoves.cloudy.cloudy


@Composable
fun MainView(modifier: Modifier = Modifier,
             changeLocationFunction: () -> Unit,
             settingsFunction: () -> Unit,
             viewModel: MainViewModel = viewModel()
){
    val paddingState = viewModel.paddingState?: PaddingState(0,0)
    val whetherData = viewModel.whetherData
    val currentLocation = viewModel.currentLocation

    Scaffold(
        modifier = modifier
            .fillMaxWidth(),
        topBar = {
            ToolBar(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 10.dp)
                    .offset(y = paddingState.top.dp),
                currentLocation  = currentLocation!!.name,
                changeLocationFunction = changeLocationFunction,
                settingsFunction = settingsFunction
            )
        }
    ){
        inerPading ->
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter,
        ){
            Image(
                painter = painterResource(id = R.drawable.test_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            MainSlide(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                whetherData = whetherData!!,
                innerPadding = inerPading.calculateTopPadding(),
                statusPadding = paddingState.top,
                bottonPadding = paddingState.bottom
            )
            }
        }
    }



@Preview
@Composable
fun PreviewMainView() {
    PohozheTheme {
        MainView(
            changeLocationFunction = {},
            settingsFunction = {}
        )
    }
}
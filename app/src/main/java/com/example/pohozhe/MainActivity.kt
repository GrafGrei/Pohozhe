package com.example.pohozhe

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pohozhe.DataProcessing.uiData.APIProcessing.GetCurrentLocation
import com.example.pohozhe.DataProcessing.uiData.APIProcessing.RequestLocationPermissionOnce
import com.example.pohozhe.DataProcessing.uiData.getStatusAndNavBarHeight
import com.example.pohozhe.views.MainView
import com.example.pohozhe.dataclasses.PaddingState
import com.example.pohozhe.ui.theme.PohozheTheme
import com.example.pohozhe.views.LocationView
import com.example.pohozhe.DataProcessing.uiData.APIProcessing.GetWhether

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        setContent {
            PohozheTheme {
                println("LaunchedEffect triggered")

                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }

    @Composable
    fun AppNavHost(navController: NavHostController) {

        val (topInsetPx, bottomInsetPx) = getStatusAndNavBarHeight()
        val viewModel = MainViewModel()

        viewModel.paddingState = PaddingState(topInsetPx, bottomInsetPx)

//        RequestLocationPermissionOnce { isGranted ->
//            viewModel.locationPermissionGranted = isGranted
//        }
//        println(viewModel.locationPermissionGranted)
//
//
//        if (viewModel.locationPermissionGranted){
//            GetCurrentLocation(viewModel)
//        }

        GetWhether(
            viewModel = viewModel
        )


        NavHost(navController, startDestination = "home") {
            composable("home") {
                MainView(
                    changeLocationFunction = {
                        navController.navigate("locations")
                    },
                    settingsFunction = {},
                    viewModel = viewModel
                )
            }
            composable("locations") {
                LocationView(
                    modifier = Modifier,
                    returnFunction = {
                        navController.popBackStack()
                    },
                    SearchButtonClick = {

                    },
                    viewModel = viewModel
                )
            }
        }
    }

}




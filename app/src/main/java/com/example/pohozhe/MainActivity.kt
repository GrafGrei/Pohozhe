package com.example.pohozhe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat
import com.example.pohozhe.DataProcessing.getStatusAndNavBarHeight
import com.example.pohozhe.UI.MainView
import com.example.pohozhe.dataclasses.DayWhether
import com.example.pohozhe.dataclasses.HourlyWhether
import com.example.pohozhe.dataclasses.WetherState
import com.example.pohozhe.dataclasses.WhetherData
import com.example.pohozhe.dataclasses.Wind
import com.example.pohozhe.ui.theme.PohozheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        setContent {
            PohozheTheme {
                val (topInsetPx, bottomInsetPx) = getStatusAndNavBarHeight()
                MainView(
                    whetherData =  WhetherData(
                        WetherState("Хмарно", R.drawable.cloudy_wether_ico),
                        19,
                        listOf(
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                            HourlyWhether(R.drawable.cloudy_wether_ico,18, stringResource(R.string.now)),
                        ),
                        listOf(
                            DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                            DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                            DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                            DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today),
                            DayWhether(23, 12, R.drawable.cloudy_wether_ico, R.string.today)
                        ),
                        12,
                        0.3F,
                        Wind(10, 122.2),
                        5,
                        1222
                    ),
                    currentLocation = "Talne",
                    statusPadding = topInsetPx,
                    bottomPadding = bottomInsetPx
                )
            }
        }
    }
}

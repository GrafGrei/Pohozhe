package com.example.pohozhe.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    tertiary = Color.White,
    onTertiary = WhiteGray,
    secondaryContainer = BlockBackground,
    onSecondaryContainer = BlockBorder
)

private val LightColorScheme = lightColorScheme(
    tertiary = Color.White,
    onTertiary = WhiteGray,
    surface = Color.Red,
    secondaryContainer = BlockBackground,
    onSecondaryContainer = BlockBorder
)

@Composable
fun PohozheTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
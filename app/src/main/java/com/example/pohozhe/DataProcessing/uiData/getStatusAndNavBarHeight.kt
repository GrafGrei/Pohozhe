package com.example.pohozhe.DataProcessing.uiData

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.LayoutDirection

data class InsetsDp(
    val top: Int,
    val bottom: Int,
    val left: Int,
    val right: Int
)

@Composable
fun getStatusAndNavBarHeight(): InsetsDp {
    val insets = WindowInsets.systemBars

    return InsetsDp(
        top = insets.asPaddingValues().calculateTopPadding().value.toInt(),
        bottom = insets.asPaddingValues().calculateBottomPadding().value.toInt(),
        left = insets.asPaddingValues().calculateLeftPadding(layoutDirection = LayoutDirection.Ltr).value.toInt(),
        right = insets.asPaddingValues().calculateRightPadding(layoutDirection = LayoutDirection.Ltr).value.toInt()
    )
}
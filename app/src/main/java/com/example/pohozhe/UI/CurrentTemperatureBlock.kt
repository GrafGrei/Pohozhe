package com.example.pohozhe.UI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pohozhe.DataProcessing.getLocalizedDegreesText
import com.example.pohozhe.R
import com.example.pohozhe.ui.theme.PohozheTheme

@Composable
fun CurrentTemperatureBlock(modifier: Modifier = Modifier, current_temperature: Int) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .aspectRatio(1F)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .padding(top = 22.dp, bottom = 20.dp)
    ) {
        Spacer(
            modifier = Modifier.weight(0.05f)
        )
        Text(
            text = current_temperature.toString(),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.geologica)),
                fontWeight = FontWeight(900),
                color = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Center,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                ),
            ),
            fontSize = 76.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(getLocalizedDegreesText(
                LocalContext.current.resources.configuration.locales[0],
                current_temperature
            )),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 10.sp,
                fontFamily = FontFamily(Font(R.font.geologica)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Center,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                ),
            ),
            modifier =  Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
    }
}


@Preview(widthDp = 190, heightDp = 190, locale = "UK")
@Composable
fun PreviewCurrentTemperatureBlock(){
    PohozheTheme {
        CurrentTemperatureBlock(current_temperature = 2)
    }
}

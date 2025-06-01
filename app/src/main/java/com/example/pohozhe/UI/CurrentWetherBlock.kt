package com.example.pohozhe.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
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
import com.example.pohozhe.dataclasses.WetherState
import com.example.pohozhe.R
import com.example.pohozhe.ui.theme.PohozheTheme

@Composable
fun CurrenWetherBlock(modifier: Modifier = Modifier, wether_state: WetherState){
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .aspectRatio(1F)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .aspectRatio(1F)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .padding(top = 22.dp, bottom = 20.dp)
    ) {
        Image(
            painter = painterResource(id = wether_state.Ico),
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(1F)
                .weight(1F)

        )
        Text(
            text = wether_state.Text,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 14.sp,
                fontFamily = FontFamily(Font(R.font.geologica)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.tertiary,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                ),
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
    }
}


@Preview(widthDp = 190, heightDp = 190)
@Composable
fun PreviewCurrenWetherBlock(){
    PohozheTheme {
        CurrenWetherBlock(wether_state = WetherState(
            Text = stringResource(R.string.cloudy),
            Ico = R.drawable.cloudy_wether_ico
        ))
    }
}

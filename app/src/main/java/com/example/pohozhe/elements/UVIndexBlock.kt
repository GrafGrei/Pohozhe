package com.example.pohozhe.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pohozhe.R
import com.example.pohozhe.ui.theme.PohozheTheme

@Composable
fun UVIndexBlock(modifier: Modifier=Modifier, currentUVIndex: Int){
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .height(113.dp)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(size = 24.dp)
            )
            .padding(top = 20.dp, start = 20.dp, end = 15.dp, bottom = 20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(22.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.uv_index_ico),
                    contentDescription = "image description",
                    modifier = Modifier
                        .width(22.dp)
                        .height(22.dp)
                )
                Text(
                    text = stringResource(R.string.uvindex),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 14.sp,
                        fontFamily = FontFamily(Font(R.font.geologica)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.tertiary,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    text = currentUVIndex.toString(),
                    style = TextStyle(
                        fontSize = 36.sp,
                        lineHeight = 14.sp,
                        fontFamily = FontFamily(Font(R.font.geologica)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.tertiary,
                    ),
                    modifier = Modifier
                        .width(30.dp)
                        .fillMaxHeight()
                        .padding()
                )
                Text(
                    text = stringResource(R.string.mm),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 14.sp,
                        fontFamily = FontFamily(Font(R.font.geologica)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onTertiary,
                        textAlign = TextAlign.Left,
                    ),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
        }
        Box(
            modifier = Modifier
                .width(20.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.TopCenter,
        ){
            Box(
                modifier = Modifier
                    .width(10.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF4CAF50),
                                Color(0xFFFFEB3B),
                                Color(0xFFF44336),
                                Color(0xFFE91E63)
                            )
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(Color.Yellow, shape = CircleShape)
                    .border(1.dp, Color.White, CircleShape)
            )
        }
    }
}




@Preview(widthDp = 190)
@Composable
fun PreviewUVIndexBlock(){
    PohozheTheme {
        UVIndexBlock(
            currentUVIndex = 2
        )
    }
}
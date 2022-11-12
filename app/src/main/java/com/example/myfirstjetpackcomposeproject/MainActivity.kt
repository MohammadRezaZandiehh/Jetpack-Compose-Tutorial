package com.example.myfirstjetpackcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.net.CookieHandler

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .padding(22.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                CircleImageView(
                    painterResource(id = R.drawable.downloadd),
                    size = 180.dp
                )
            }
        }
    }

    @Composable
    fun CircleImageView(painter: Painter, size: Dp) {
        Image(
            painter = painter,
            contentDescription = "circle image",
            modifier = Modifier
                .clip(CircleShape)
//                .clip(RectangleShape)
                .size(size)
                .border(
                    width = 6.dp,
                    color = Color.Green,
                    shape = CircleShape
//                    shape = RectangleShape
                )
        )
    }

    @Composable
    fun BoxCard(title: String, price: String, image: Painter) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 16.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(modifier = Modifier.height(200.dp)) {

                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )

                }
            }
        }
    }


    @Composable
    fun CardView(title: String, price: String, image: Painter) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 16.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxSize()
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Text(
                        text = price,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Red
                    )

                }
            }
        }
    }

    @Composable
    fun AndroidItem(title: String, desc: String, image: Painter, price: String) {
        Column() {
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                )

                Text(
                    text = price,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Magenta,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Text(
                text = desc,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 8.dp, bottom = 32.dp, top = 4.dp)
            )
        }
    }

/*    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        GeneralTheme {
            CircleImageView(
                painterResource(id = R.drawable.downloadd),
                size = 180.dp
            )
        }
    }*/
}
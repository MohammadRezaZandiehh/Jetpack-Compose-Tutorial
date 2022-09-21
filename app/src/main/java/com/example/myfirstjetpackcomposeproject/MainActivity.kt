package com.example.myfirstjetpackcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {

                AndroidItem(
                    "title",
                    "desc",
                    painterResource(id = R.drawable.download),
                    "365"
                )

                AndroidItem(
                    "title2",
                    "desc2",
                    painterResource(id = R.drawable.learnandroiddevelopment),
                    "3652"
                )


                AndroidItem(
                    "title3",
                    "desc3",
                    painterResource(id = R.drawable.download),
                    "3653"
                )

                AndroidItem(
                    "title4",
                    "desc4",
                    painterResource(id = R.drawable.learnandroiddevelopment),
                    "3654"
                )

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
}
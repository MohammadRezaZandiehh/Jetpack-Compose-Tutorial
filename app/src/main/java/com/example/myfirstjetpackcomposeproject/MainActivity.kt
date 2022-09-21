package com.example.myfirstjetpackcomposeproject

import android.os.Bundle
import android.webkit.WebSettings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstjetpackcomposeproject.ui.theme.MyFirstJetpackComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyButton()

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CounterNumber()



                Row() {

                    Button(onClick = { counter.value++ }, modifier = Modifier.padding(8.dp))
                    { Text("Increase") }

                    Button(onClick = { counter.value-- }, modifier = Modifier.padding(8.dp))
                    { Text("decrease") }
                }

            }

        }
    }
}

private var counter = mutableStateOf(0)

@Composable
fun CounterNumber() {
    /*STATE: */
    var count by remember { counter }

    Text(
        text = count.toString(),
        modifier = Modifier.padding(16.dp),
        fontSize = 50.sp,
        fontWeight = FontWeight.ExtraBold
    )
}

@Composable
fun MyButton() {
    /*STATE: */
    var btnState by remember { mutableStateOf(true) }
    Button(
        onClick = {
            btnState = !btnState
        },
        modifier = Modifier
            .size(140.dp)
            .padding(16.dp)
    ) {
        Text(text = btnState.toString())
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFirstJetpackComposeProjectTheme {
        Greeting("Android")
    }
}

/*
* Recomposition: the mechanism in which state changes are reflected within an app's UI.*/
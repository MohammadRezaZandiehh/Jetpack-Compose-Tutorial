package com.example.myfirstjetpackcomposeproject

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.myfirstjetpackcomposeproject.ui.theme.Purple500
import kotlinx.coroutines.launch
import kotlin.math.roundToInt
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState = rememberScaffoldState()       // save state of scafold here
            val scope = rememberCoroutineScope()
            val modalState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

            Scaffold(
                scaffoldState = scaffoldState,               // related to top comment
                topBar = {
                    MyTopAppBar()
                },
                bottomBar = {
                    BottomAppBarView()
                },
                drawerContent = {
                    Text(text = "Hello drawer")
                },
                floatingActionButtonPosition = FabPosition.End,
                floatingActionButton = {
                    FloatingActionButton(onClick = {
                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("Hello")
                            modalState.show()
                        }
                    }) {
                        Text(text = "Hi!")
                    }
                },
                content = {
                    Column {
                        AndroidView(
                            modifier = Modifier.fillMaxWidth(),
                            factory = {
                                TextView(it)
                            }
                        ){
                            textView->
                            textView.apply {
                                text = "Hello From Compose In XML"
                                textSize = 20f
                                gravity = Gravity.CENTER
                            }
                        }

                        AndroidView(
                            factory = {
                                android.widget.Button(it)
                            }
                        ){
                            btn->
                            btn.apply {
                                text = "My Button"
                                layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
                                setOnClickListener{

                                }
                            }
                        }
                    }
                })
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun ExpandableCard() {
    var expandState by remember {
        mutableStateOf(false)
    }

    val rotationState by animateFloatAsState(
        targetValue = if (expandState) 180F else 0F
    )

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300
                )
            ),
        shape = RoundedCornerShape(9.dp),
        onClick = {
            expandState = !expandState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "My Title",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandState = !expandState
                    }
                ) {
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = "")
                }
            }
            if (expandState) {
                Text(
                    text = "kjfhidfidfi;dshfihso;fh;shishiohil das das das das das d sad as das a f fr g reg re gre g reg re gre g erg brbvksdkjv jsdk vjsd vjksd kvjsd jkf sdjkflbv sh ghgjs gsjg sjgjsdfjs ghesgh ewhgweh gwe gjkwe gkewhjf wejkf ewk fjke fjles kjg ksj. gjskegjk.er giuwregiusgoslgjks g skig sefhsfisefeshilehfisasehfiehsfihewfefn efiehfies fsiofjislf is;fsf sdil;fjisd;f sd;fsdlf slfsdf osofhioeehfe fu ieuhfoeaf uea;hfuaef ioahfuahfiosdfh8s dofih si8f eofses feofoe8f eioaf f  fae fea ;fiehuse kjfhidfidfi;dshfihso;fh;shishiohil das das das das das d sad as das a f fr g reg re gre g reg re gre g erg brbvksdkjv jsdk vjsd vjksd kvjsd jkf sdjkflbv sh ghgjs gsjg sjgjsdfjs ghesgh ewhgweh gwe gjkwe gkewhjf wejkf ewk fjke fjles kjg ksj. gjskegjk.er giuwregiusgoslgjks g skig sefhsfisefeshilehfisasehfiehsfihewfefn efiehfies fsiofjislf is;fsf sdil;fjisd;f sd;fsdlf slfsdf osofhioeehfe fu ieuhfoeaf uea;hfuaef ioahfuahfiosdfh8s dofih si8f eofses feofoe8f eioaf f  fae fea ;fiehuse "
                )
            }
        }
    }
}


@Composable
fun AnimateToDp() {
    var sizeState by remember {
        mutableStateOf(100.dp)
    }

    val size by animateDpAsState(
        targetValue = sizeState,
        tween(
            durationMillis = 3000,
            delayMillis = 1000
        )
    )
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = painterResource(id = R.drawable.downloadd),
            contentDescription = "",
            modifier = Modifier
                .size(size)
        )
        Row(
            Modifier.padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { sizeState += 50.dp }) {
                Text(text = "Increase Image")
            }

            Button(onClick = { sizeState -= 50.dp }) {
                Text(text = "Decrease Image")
            }
        }

    }
}


@Composable
fun InfiniteAnimation() {
    val infiniteTransition = rememberInfiniteTransition()
    val size by infiniteTransition.animateFloat(
        initialValue = 100.0f,
        targetValue = 150.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, 100),
            repeatMode = RepeatMode.Reverse
        )
    )

    Image(
        painter = painterResource(id = R.drawable.downloadd),
        contentDescription = "",
        modifier = Modifier
            .size(size.dp)
    )
}

@Composable
fun RotateAnimation() {
    var isRotate by remember {
        mutableStateOf(false)
    }
    val rotateAngle by animateFloatAsState(
        targetValue = if (isRotate) 360f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.downloadd),
            contentDescription = "",
            modifier = Modifier
                .rotate(rotateAngle)
                .size(150.dp)
        )

        Button(onClick = { isRotate = !isRotate }) {
            Text(text = "Rotate Image")
        }
    }
}


@Composable
fun AnimateColor() {
    var isNeedColorChange by remember {
        mutableStateOf(false)
    }
    val startColor = Color.Red
    val endColor = Color.Blue
    val backgroundColor by animateColorAsState(
        targetValue = if (isNeedColorChange) endColor else startColor,
        animationSpec = tween(
            durationMillis = 5000,
            delayMillis = 100
        )                                           /*in animationSpec we specify how long does animation be determined, or what kind of delay? and how does it be played? */
    )

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .background(backgroundColor)
        )
        Button(
            onClick = { isNeedColorChange = !isNeedColorChange }
        ) {
            Text(text = "change color")
        }
    }
}

@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    LottieAnimation(
        composition,
        iterations = LottieConstants.IterateForever
    )
}


@Composable
fun WalletItem(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(0.15f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircleImageView(painter = painterResource(id = R.drawable.downloadd), size = 32.dp)
            }

            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(0.475f)
            ) {
                Text(
                    text = name,
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Text(
                    text = "BTC/USD",
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.Gray
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, end = 16.dp)
                    .weight(0.475f),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "BTC 0.0654",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "Bitcoin",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(0XFF299C0D)
                )
            }
        }
    }
}

@Composable
fun BottomAppBarView() {
    BottomAppBar(
        backgroundColor = Purple500
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = {

            },
            label = {
                Text(text = "Home")
            },
            icon = {
                Icon(Icons.Filled.Home, contentDescription = "")
            }
        )

        BottomNavigationItem(
            selected = false,
            onClick = {

            },
            label = {
                Text(text = "Setting")
            },
            icon = {
                Icon(Icons.Filled.Settings, contentDescription = "")
            }
        )

        BottomNavigationItem(
            selected = false,
            onClick = {

            },
            label = {
                Text(text = "Profile")
            },
            icon = {
                Icon(Icons.Filled.Info, contentDescription = "")
            }
        )

        BottomNavigationItem(
            selected = false,
            onClick = {

            },
            label = {
                Text(text = "Menu")
            },
            icon = {
                Icon(Icons.Filled.Menu, contentDescription = "")
            }
        )
    }
}

val openDialogState = mutableStateOf(false)

@Composable
fun ExitAlertDialog() {
    MaterialTheme {
        val openDialog = remember {
            openDialogState
        }
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },                                  //onDismissRequest: if we click out of alertDialog
                title = {
                    Text(text = "Exit App")
                },
                text = {
                    Text(text = "Are you sure to exit app?")
                },
                confirmButton = {
                    Button(onClick = {
                        openDialogState.value = false
                        Log.e("3636", "OK")
                        exitProcess(0)         /*exitProcess: exit app*/
                    }) {
                        Text(text = "ok")
                    }
                },
                dismissButton = {
                    Button(onClick = { openDialogState.value = false }) {
                        Text(text = "cancel")
                    }
                }
            )
        } else {

        }

    }
}


@Composable
fun MyTopAppBar() {
    Column(/*modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)*/) {
        TopAppBar(
            elevation = 10.dp,
            title = {
                Text(text = "Agha Jamshid")
            },
            backgroundColor = Purple500,
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Menu, null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Star, null)
                }
            },
            navigationIcon = {
                IconButton(onClick = { openDialogState.value = true }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }
        )
    }
}

@Composable
fun MyEditText() {

    //build state for changing inputText:
    var textState by remember {
        mutableStateOf(TextFieldValue("agha"))
    }
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textState,
            onValueChange = {
                textState = it
            }
        )

        Text(text = "your text is: ${textState.text}")


        Row() {
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    Log.e("3636", textState.text)
                }
            ) {
                Text(text = "LogIn")
            }

            OutlinedButton(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    Log.e("3636", textState.text)
                }
            ) {
                Text(text = "Register")
            }
        }

        TextButton(
            onClick = {
                Log.e("3636", textState.text)
            }
        ) {
            Text(text = "forget password? ")
        }
    }
}


@Composable
fun SeekBarView() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    Column() {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            }
        )

        Text(text = (sliderPosition * 100).roundToInt().toString())
    }
}


@Composable
fun SwitchView() {
    var checkState by remember {
        mutableStateOf(true)
    }
    Switch(
        checked = checkState,
        onCheckedChange = {
            checkState = it
        }
    )
}


@Composable
fun RadioButtonView() {
    val radioOption = listOf("radio1", "radio2", "radio3")

    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(radioOption[0])
    }

    Row {
        radioOption.forEach { text ->
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .selectable(
                        selected = text == selectedOption,
                        onClick = {
                            onOptionSelected(text)
                            Log.e("3636", text)
                        }
                    )
            ) {
                RadioButton(
                    selected = text == selectedOption,
                    onClick = {
                        onOptionSelected(text)
                        Log.e("3636", text)
                    }
                )

                Text(
                    text = text,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        }
    }

}

@Composable
fun CheckBoxView() {
    var checkState by remember {
        mutableStateOf(true)
    }
    Checkbox(
        checked = checkState,
        onCheckedChange =
        {
            checkState = it
        })
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
/*            .border(
                width = 6.dp,
                color = Color.Green,
                shape = CircleShape
//                    shape = RectangleShape
            )*/
    )
}

@Composable
fun BoxCard(title: String, price: String, image: Painter) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 16.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier
                .height(180.dp)
                .width(150.dp)
        ) {

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
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 16.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .width(130.dp)
                .height(160.dp)
        ) {
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

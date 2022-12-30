package com.example.myfirstjetpackcomposeproject.ui.theme

import androidx.compose.runtime.*
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

enum class CustomTheme {
    DARK, LIGHT
}

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val dark22 = Color(0xFF222222)
val lightCC = Color(0xFFcccccc)

@Stable                                 /*@Stable: It's a kind of Observer. I mean when in compose each color was changed, at the moment come and do some work. --> the reComposition operation will be worked better than before.*/
class CustomColor(
    backgroundColor: Color,
    buttonBackgroundColor: Color,
    buttonTextColor: Color,
    textColor: Color,
    floatingActionButtonColor:Color
) {
    var backgroundColor by mutableStateOf(backgroundColor)
        private set

    var buttonBackgroundColor by mutableStateOf(buttonBackgroundColor)
        private set

    var buttonTextColor by mutableStateOf(buttonTextColor)
        private set

    var textColor by mutableStateOf(textColor)
        private set

    var floatingActionButtonColor by mutableStateOf(floatingActionButtonColor)
        private set


    fun update(color: CustomColor) {                                 /*when was updated, get new customColor and replace the previous one*/
        this.backgroundColor = color.backgroundColor
        this.buttonBackgroundColor = color.buttonBackgroundColor
        this.buttonTextColor = color.buttonTextColor
        this.textColor = color.textColor
        this.floatingActionButtonColor = color.floatingActionButtonColor
    }

    fun initColors() =                                              /*first placement*/
        CustomColor(backgroundColor, buttonBackgroundColor, buttonTextColor, textColor, floatingActionButtonColor)
}




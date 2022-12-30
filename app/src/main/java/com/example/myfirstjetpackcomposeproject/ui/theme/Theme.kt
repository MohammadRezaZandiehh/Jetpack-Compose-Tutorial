package com.example.myfirstjetpackcomposeproject.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*

private val CustomDarkColor = CustomColor(
    backgroundColor = dark22,
    buttonBackgroundColor = Teal200,
    buttonTextColor = dark22,
    textColor = lightCC,
    floatingActionButtonColor = Teal200
)

private val CustomLightColor = CustomColor(
    backgroundColor = lightCC,
    buttonBackgroundColor = Purple500,
    buttonTextColor = lightCC,
    textColor = dark22,
    floatingActionButtonColor = Purple500
)

private val LocalColorsProvider = staticCompositionLocalOf {
    CustomLightColor
}

/*agar bekhaym masalan dar mainActivity moon az in systeme theming i k neveshtim estefade knim, yani b in theme haei k neveshtim dasresi dashte bashim bayad ye chizi dashte bashim b name LocalProvider.*/
@Composable
fun CustomLocalProvider(
    colors: CustomColor,
    content: @Composable () -> Unit
) {
    val colorPalette =
        remember { colors.initColors() }         /*baraye rang haye default bia initColors() ro bezar --> dar vaghe baraye meghdar avalie ye state i hast k inja tarif kardim*/
    colorPalette.update(colors)                                 /*inja ham miaym va updatesh mikonim*/

    CompositionLocalProvider(
        LocalColorsProvider provides colorPalette,
        content = content
    )
}

private val CustomTheme.colors: Pair<Colors, CustomColor>
    get() = when (this) {
        CustomTheme.DARK -> darkColors() to CustomDarkColor
        CustomTheme.LIGHT -> lightColors() to CustomLightColor
    }


object CustomThemeManager {
    val colors: CustomColor
        @Composable
        get() = LocalColorsProvider.current

    var customTheme by mutableStateOf(CustomTheme.LIGHT)

    fun isSystemInDarkTheme(): Boolean {
        return customTheme == CustomTheme.DARK
    }
}


@Composable
fun MyFirstJetpackComposeProjectTheme(                   /*Project Name*/
    customTheme: CustomTheme = CustomThemeManager.customTheme,
    content: @Composable () -> Unit
) {
    val (colorPalette, myColor) = customTheme.colors

    CustomLocalProvider(colors = myColor) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

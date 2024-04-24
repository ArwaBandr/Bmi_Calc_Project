package com.example.bmicalcproject.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFAD88C6)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFFAD88C6)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

//object BmiColor {
//    var isLightMode by mutableStateOf(true)
//    var bc = if (isLightMode) Color(0xFFBACD92) else Color(0xFF191B13)
//    val content = Color(0xFF12372A)
//    val backgroundcolor = Color(0xFFBACD92)
//    val primarycolor = Color(0xFF75A47F)
//    val characterColor = Color(0xFF436850)
//}
object BmiColor {
    var isLightMode by mutableStateOf(true)
    var primarycolor= if(isLightMode) Color(0xFF266c2b) else Color(0xFF8fd88a)
    var onprimarycolor=if(isLightMode) Color(0xFFffffff) else Color(0xFF00390b)
    var primarycontaine =if(isLightMode) Color(0xFFaaf5a4) else Color(0xFF055315)
    var OnPrimaryContainer =if(isLightMode)Color(0xFF002204) else Color(0xFFaaf5a4)
    var  backgroundcolor = if(isLightMode) Color(0xFFBACD92) else Color(0xFF1E201D)
    var  onbackgroundcolor = if(isLightMode) Color(0xFFBACD92) else Color(0xFFB0BE69)
    val characterColor = Color(0xFF436850)
}
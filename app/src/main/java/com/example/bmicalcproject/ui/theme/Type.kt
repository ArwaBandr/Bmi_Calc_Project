package com.example.bmicalcproject.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(

     titleLarge = TextStyle(
         fontSize = 30.sp,
         fontWeight = FontWeight.Bold,
         fontFamily = FontFamily.Cursive,
         color = BmiColor.onprimarycolor
     ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = BmiColor.onprimarycolor
    )
)
package com.example.bmicalcproject.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme  = darkColorScheme(
    primary = BmiColor.primarycolor,
    onPrimary = BmiColor.onprimarycolor,
    primaryContainer = BmiColor.primarycontaine,
    onPrimaryContainer = BmiColor.OnPrimaryContainer,
    background = BmiColor.backgroundcolor,
    onBackground = BmiColor.onbackgroundcolor

)

private val LightColorScheme = lightColorScheme(
    primary = BmiColor.primarycolor,
    onPrimary = BmiColor.onprimarycolor,
    primaryContainer = BmiColor.primarycontaine,
    onPrimaryContainer = BmiColor.OnPrimaryContainer,
    background = BmiColor.backgroundcolor,
    onBackground = BmiColor.onbackgroundcolor

)

@Composable
fun BmiCalcProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    content: @Composable () -> Unit
) {

    BmiColor.isLightMode= !darkTheme

    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
       colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
package com.djtube.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF10B981), // Emerald DJTube Green
    onPrimary = Color.Black,
    secondary = Color(0xFF14B8A6),
    background = Color(0xFF0F172A),
    surface = Color(0xFF1E293B),
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun DJTubeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography(),
        content = content
    )
}

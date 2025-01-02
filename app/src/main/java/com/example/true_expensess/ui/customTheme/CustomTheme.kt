package ai.truelink.app.ui.customTheme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalBaseColorSystem = staticCompositionLocalOf {
    BaseColors
}

val LocalSystemColorSystem = staticCompositionLocalOf {
    SystemColors
}

val LocalThemeColorSystem = staticCompositionLocalOf<ThemeColors> {
    LightThemeColors
}

val LocalTypographySystem = staticCompositionLocalOf {
    TypographySystem()
}

@Composable
fun Theme (
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

   val themeColors = if (isDarkTheme) DarkThemeColors else LightThemeColors

    CompositionLocalProvider(
        LocalBaseColorSystem provides BaseColors,
        LocalSystemColorSystem provides SystemColors,
        LocalThemeColorSystem provides themeColors,
        LocalTypographySystem provides TypographySystem(color = themeColors.Text.Active),
        content = content
    )
}

object Theme {
    val Mapped: ThemeColors
        @Composable
        get() = LocalThemeColorSystem.current

    val Base: BaseColors
        @Composable
        get() = LocalBaseColorSystem.current

    val System: SystemColors
        @Composable
        get() = LocalSystemColorSystem.current
    val Typography: TypographySystem
        @Composable
        get() = LocalTypographySystem.current
}
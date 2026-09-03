package IV_ONE_team.com.github.euroone_kotlin.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val EuroLightColors = lightColorScheme(
    primary = EuroPalette.Brand500,
    onPrimary = EuroPalette.Ink0,
    primaryContainer = EuroPalette.Brand100,
    onPrimaryContainer = EuroPalette.Brand900,
    secondary = EuroPalette.BlueLight,
    onSecondary = EuroPalette.Ink0,
    tertiary = EuroPalette.Yellow,
    onTertiary = EuroPalette.Brand900,
    background = EuroPalette.Ink50,
    onBackground = EuroPalette.Ink900,
    surface = EuroPalette.Ink0,
    onSurface = EuroPalette.Ink900,
    surfaceVariant = EuroPalette.Ink100,
    onSurfaceVariant = EuroPalette.Ink600,
    error = EuroPalette.Critical,
    onError = EuroPalette.Ink0,
    outline = EuroPalette.Ink300
)

/**
 * Tema Material 3 do EuroOne. Nao usa dynamic color para preservar a
 * identidade institucional Eurofarma em todos os dispositivos.
 */
@Composable
fun EuroOneTheme(content: @Composable () -> Unit) {
    val colorScheme = EuroLightColors
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = EuroPalette.Brand800.toArgb()
            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightStatusBars = false
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = EuroTypography,
        content = content
    )
}

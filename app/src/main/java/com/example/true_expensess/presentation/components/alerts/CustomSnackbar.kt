package ai.truelink.app.presentation.components.alerts

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.true_expensess.ui.customTheme.Theme

/**
 * A composable function that displays a custom Snackbar.
 *
 * @param snackbarHostState The state of the SnackbarHost.
 */
@Composable
fun CustomSnackbar(snackbarHostState: SnackbarHostState) {
    SnackbarHost(hostState = snackbarHostState) { snackbarData ->
        val customSnackbarVisuals = snackbarData.visuals as CustomSnackbarVisuals
        Snackbar(
            snackbarData = snackbarData,
            contentColor = customSnackbarVisuals.textColor,
            containerColor = customSnackbarVisuals.containerColor,
            dismissActionContentColor = customSnackbarVisuals.textColor,
            actionContentColor = customSnackbarVisuals.textColor,
            actionColor = customSnackbarVisuals.textColor,
        )
    }
}

/**
 * Enum class representing the type of Snackbar.
 */
enum class SnackbarType {
    Success,
    Error,
    Warning,
    Neutral
}

/**
 * Data class representing the visuals of a custom Snackbar.
 *
 * @property message The message to be displayed in the Snackbar.
 * @property actionLabel The label for the action button in the Snackbar.
 * @property duration The duration for which the Snackbar is displayed.
 * @property withDismissAction Whether the Snackbar has a dismiss action.
 * @property type The type of the Snackbar.
 */
data class CustomSnackbarVisuals(
    override val message: String,
    override val actionLabel: String? = null,
    override val duration: SnackbarDuration = SnackbarDuration.Short,
    override val withDismissAction: Boolean = true,
    val type: SnackbarType = SnackbarType.Success
) : SnackbarVisuals {
    /**
     * The background color of the Snackbar container based on the Snackbar type.
     */
    val containerColor: Color
        @Composable get() = when (type) {
            SnackbarType.Success -> Theme.Mapped.Success.Main
            SnackbarType.Error -> Theme.Mapped.Error.Main
            SnackbarType.Warning -> Theme.Mapped.Warning.Main
            SnackbarType.Neutral -> Theme.Mapped.Surface500
        }

    /**
     * The text color of the Snackbar based on the Snackbar type.
     */
    val textColor: Color
        @Composable get() = when (type) {
            SnackbarType.Success -> Theme.Mapped.Success.TextMain
            SnackbarType.Error -> Theme.Mapped.Error.TextMain
            SnackbarType.Warning -> Theme.Mapped.Warning.TextMain
            SnackbarType.Neutral -> Theme.Mapped.Text.Active
        }
}
package shortener.truelink.app.presentation.components.buttons

import ai.truelink.app.ui.customTheme.Theme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import shortener.truelink.app.presentation.components.buttons.ButtonColorType.ERROR
import shortener.truelink.app.presentation.components.buttons.ButtonColorType.INFO
import shortener.truelink.app.presentation.components.buttons.ButtonColorType.INHERIT
import shortener.truelink.app.presentation.components.buttons.ButtonColorType.PRIMARY
import shortener.truelink.app.presentation.components.buttons.ButtonColorType.SECONDARY
import shortener.truelink.app.presentation.components.buttons.ButtonColorType.SUCCESS
import shortener.truelink.app.presentation.components.buttons.ButtonColorType.WARNING
import shortener.truelink.app.presentation.components.buttons.ButtonShapeType.CIRCULAR
import shortener.truelink.app.presentation.components.buttons.ButtonShapeType.ROUNDED
import shortener.truelink.app.presentation.components.buttons.ButtonSizeType.LARGE
import shortener.truelink.app.presentation.components.buttons.ButtonSizeType.MEDIUM
import shortener.truelink.app.presentation.components.buttons.ButtonSizeType.SMALL

/**
 * Type of default button colors.
 *
 * @property PRIMARY Primary button color, using the theme's accent color.
 * @property SECONDARY Secondary button color, using the theme's primary color.
 * @property SUCCESS Success button color, using the theme's success color.
 * @property ERROR Error button color, using the theme's error color.
 * @property WARNING Warning button color, using the theme's warning color.
 * @property INFO Info button color, using the theme's info color.
 * @property INHERIT Inherit button color, using the theme's text color.
 *
 */
enum class ButtonColorType {
    PRIMARY, SECONDARY, SUCCESS, ERROR, WARNING, INFO, INHERIT, SURFACE
}

/**
 * Type of button sizes.
 *
 * @property SMALL Small button size.
 * @property MEDIUM Medium button size.
 * @property LARGE Large button size.
 *
 */
enum class ButtonSizeType {
    SMALL, MEDIUM, LARGE
}

/**
 * Type of button shapes.
 *
 * @property ROUNDED Rounded button shape.
 * @property CIRCULAR Circular button shape.
 *
 */
enum class ButtonShapeType {
    ROUNDED, CIRCULAR
}

/**
 * A class to define button properties for different sizes.
 *
 * @param padding Padding values for the button.
 * @param textStyle Text style for the button.
 * @param iconSize Size of the icon.
 *
 */
data class ButtonSizeProperties(
    val padding: PaddingValues,
    val textStyle: TextStyle,
    val iconSize: Dp,
    val minWidth: Dp = 10.dp,
    val minHeight: Dp = 0.dp,
)

object CustomButtonDefaults {

    @Composable
    fun filledButtonColors(
        type: ButtonColorType
    ): ButtonColors {
        return when (type) {
            ButtonColorType.PRIMARY -> {
                ButtonDefaults.buttonColors(
                    containerColor = Theme.Mapped.Primary.Main,
                    contentColor = Theme.Mapped.Primary.TextMain,
                    disabledContainerColor = Theme.Mapped.Surface600,
                    disabledContentColor = Theme.Mapped.Text.Disabled,
                )
            }

            ButtonColorType.SECONDARY -> {
                ButtonDefaults.buttonColors(
                    containerColor = Theme.Mapped.Secondary.Main,
                    contentColor = Theme.Mapped.Secondary.TextMain,
                    disabledContainerColor = Theme.Mapped.Secondary.Disabled,
                    disabledContentColor = Theme.Mapped.Secondary.TextDisabled,
                )
            }

            ButtonColorType.SURFACE -> {
                ButtonDefaults.buttonColors(
                    containerColor = Theme.Mapped.Surface500,
                    contentColor = Theme.Mapped.Text.Active,
                    disabledContainerColor = Theme.Mapped.Surface800,
                    disabledContentColor = Theme.Mapped.Text.Disabled,
                )
            }

            ButtonColorType.SUCCESS -> {
                ButtonDefaults.buttonColors(
                    containerColor = Theme.Mapped.Success.Main,
                    contentColor = Theme.Mapped.Success.TextMain,
                    disabledContainerColor = Theme.Mapped.Success.Disabled,
                    disabledContentColor = Theme.Mapped.Success.TextDisabled,
                )
            }

            ButtonColorType.ERROR -> {
                ButtonDefaults.buttonColors(
                    containerColor = Theme.Mapped.Error.Main,
                    contentColor = Theme.Mapped.Error.TextMain,
                    disabledContainerColor = Theme.Mapped.Error.Disabled,
                    disabledContentColor = Theme.Mapped.Error.TextDisabled,
                )
            }

            ButtonColorType.WARNING -> {
                ButtonDefaults.buttonColors(
                    containerColor = Theme.Mapped.Warning.Main,
                    contentColor = Theme.Mapped.Warning.TextMain,
                    disabledContainerColor = Theme.Mapped.Warning.Disabled,
                    disabledContentColor = Theme.Mapped.Warning.TextDisabled,
                )
            }

            ButtonColorType.INFO -> {
                ButtonDefaults.buttonColors(
                    containerColor = Theme.Mapped.Info.Main,
                    contentColor = Theme.Mapped.Info.TextMain,
                    disabledContainerColor = Theme.Mapped.Info.Disabled,
                    disabledContentColor = Theme.Mapped.Info.TextDisabled,
                )
            }

            ButtonColorType.INHERIT -> {
                ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Theme.Mapped.Text.Active,
                    disabledContainerColor = Color(0x80000000),
                    disabledContentColor = Theme.Mapped.Text.Disabled,
                )
            }
        }
    }

    @Composable
    fun buttonSize(
        size: ButtonSizeType
    ): ButtonSizeProperties {
        return when (size) {
            ButtonSizeType.SMALL -> ButtonSizeProperties(
                padding = PaddingValues(8.dp),
                iconSize = 16.dp,
                minHeight = 32.dp,
                textStyle = Theme.Typography.l3.copy(
                    fontWeight = FontWeight.Medium
                )
            )

            ButtonSizeType.MEDIUM -> ButtonSizeProperties(
                padding = PaddingValues(
                    start = 16.dp,
                    top = 10.dp,
                    end = 16.dp,
                    bottom = 10.dp
                ),
                textStyle = Theme.Typography.l2.copy(fontWeight = FontWeight.Medium),
                iconSize = 20.dp,
                minHeight = 40.dp
            )

            ButtonSizeType.LARGE -> ButtonSizeProperties(
                padding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                ),
                textStyle = Theme.Typography.l1.copy(fontWeight = FontWeight.Medium),
                iconSize = 24.dp,
                minHeight = 48.dp
            )
        }
    }

    fun buttonShape(
        shape: ButtonShapeType
    ): RoundedCornerShape {
        return when (shape) {
            ButtonShapeType.ROUNDED -> {
                RoundedCornerShape(8.dp)
            }

            ButtonShapeType.CIRCULAR -> {
                RoundedCornerShape(percent = 50)
            }
        }
    }
}
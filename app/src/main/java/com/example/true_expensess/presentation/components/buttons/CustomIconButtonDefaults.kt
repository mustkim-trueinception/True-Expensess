package ai.truelink.app.presentation.components.buttons

import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant.DEFAULT
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant.ERROR
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant.INFO
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant.INHERIT
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant.PRIMARY
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant.SECONDARY
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant.SUCCESS
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant.WARNING
import ai.truelink.app.presentation.components.buttons.CustomIconButtonDefaults.colors
import ai.truelink.app.presentation.components.buttons.CustomIconButtonDefaults.shape
import ai.truelink.app.presentation.components.buttons.CustomIconButtonDefaults.sizeProperties
import ai.truelink.app.presentation.components.buttons.CustomIconButtonShape.CIRCULAR
import ai.truelink.app.presentation.components.buttons.CustomIconButtonShape.ROUNDED
import ai.truelink.app.presentation.components.buttons.CustomIconButtonSize.LARGE
import ai.truelink.app.presentation.components.buttons.CustomIconButtonSize.MEDIUM
import ai.truelink.app.presentation.components.buttons.CustomIconButtonSize.SMALL
import ai.truelink.app.presentation.components.buttons.CustomIconButtonSize.XSMALL
import ai.truelink.app.ui.customTheme.Theme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * Represents the container and content colors used in an icon button in different states.
 *
 * @param containerColor the container color of this icon button when enabled.
 * @param contentColor the content color of this icon button when enabled.
 * @param disabledContainerColor the container color of this icon button when not enabled.
 * @param disabledContentColor the content color of this icon button when not enabled.
 */
class CustomIconButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
) {
    /**
     * Represents the container color for this icon button, depending on [enabled].
     *
     * @param enabled whether the icon button is enabled
     */
    @Stable
    internal fun containerColor(enabled: Boolean): Color =
        if (enabled) containerColor else disabledContainerColor

    /**
     * Represents the content color for this icon button, depending on [enabled].
     *
     * @param enabled whether the icon button is enabled
     */
    @Stable
    internal fun contentColor(enabled: Boolean): Color =
        if (enabled) contentColor else disabledContentColor

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is CustomIconButtonColors) return false

        if (containerColor != other.containerColor) return false
        if (contentColor != other.contentColor) return false
        if (disabledContainerColor != other.disabledContainerColor) return false
        if (disabledContentColor != other.disabledContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = containerColor.hashCode()
        result = 31 * result + contentColor.hashCode()
        result = 31 * result + disabledContainerColor.hashCode()
        result = 31 * result + disabledContentColor.hashCode()

        return result
    }
}

/**
 * Represents the color variants available for an icon button.
 *
 * @property PRIMARY the primary color variant.
 * @property SECONDARY the secondary color variant.
 * @property SUCCESS the success color variant.
 * @property ERROR the error color variant.
 * @property WARNING the warning color variant.
 * @property INFO the info color variant.
 * @property DEFAULT the default color variant.
 * @property INHERIT the inherit color variant.
 *
 * @see [CustomIconButton]
 * @see [CustomIconButtonDefaults]
 */
enum class CustomIconButtonColorVariant {
    PRIMARY, SECONDARY, SUCCESS, ERROR, WARNING, INFO, DEFAULT, INHERIT
}

/**
 * Represents the shape variants available for an icon button.
 *
 * @property ROUNDED the rounded shape variant.
 * @property CIRCULAR the circular shape variant.
 *
 * @see [CustomIconButton]
 * @see [CustomIconButtonDefaults]
 */
enum class CustomIconButtonShape {
    ROUNDED, CIRCULAR
}

/**
 * Represents the size variants available for an icon button.
 *
 * @property XSMALL the extra small size variant.
 * @property SMALL the small size variant.
 * @property MEDIUM the medium size variant.
 * @property LARGE the large size variant.
 *
 * @see [CustomIconButton]
 * @see [CustomIconButtonDefaults]
 */
enum class CustomIconButtonSize {
    XSMALL, SMALL, MEDIUM, LARGE
}

/**
 * Represents the size properties of an icon button.
 *
 * @property size the size of the icon button.
 * @property iconSize the size of the icon in the icon button.
 * @property contentPadding the padding of the content in the icon button.
 */
data class CustomIconButtonSizeProperties(
    val size: Dp,
    val iconSize: Dp,
    val contentPadding: Dp,
)

/**
 * Represents the default values for an icon button.
 *
 * @property colors get the default colors for the icon button based on the [CustomIconButtonColorVariant].
 * @property shape get the default shape for the icon button based on the [CustomIconButtonShape].
 * @property sizeProperties get the default size properties for the icon button based on the [CustomIconButtonSize].
 *
 * @see [CustomIconButtonColorVariant]
 * @see [CustomIconButtonShape]
 * @see [CustomIconButtonSize]
 * @see [CustomIconButtonColors]
 * @see [CustomIconButtonSizeProperties]
 * @see [CustomIconButton]
 *
 */
object CustomIconButtonDefaults {

    /**
     * Get the default [CustomIconButtonColors] for the icon button based on the [CustomIconButtonColorVariant].
     *
     * @param variant the color variant of the icon button.
     *
     * @return the [CustomIconButtonColors] for the icon button based on the [CustomIconButtonColorVariant].
     *
     * @see [CustomIconButtonColorVariant]
     * @see [CustomIconButtonDefaults]
     */
    val colors: @Composable (CustomIconButtonColorVariant) -> CustomIconButtonColors = { variant ->
        when (variant) {
            PRIMARY -> CustomIconButtonColors(
                containerColor = Theme.Mapped.Primary.Main,
                contentColor = Theme.Mapped.Text.Active,
                disabledContainerColor = Theme.Mapped.Primary.Disabled,
                disabledContentColor = Theme.Mapped.Primary.TextDisabled
            )

            SECONDARY -> CustomIconButtonColors(
                containerColor = Theme.Mapped.Secondary.Main,
                contentColor = Theme.Mapped.Text.Active,
                disabledContainerColor = Theme.Mapped.Secondary.Disabled,
                disabledContentColor = Theme.Mapped.Secondary.TextDisabled
            )

            SUCCESS -> CustomIconButtonColors(
                containerColor = Theme.Mapped.Success.Main,
                contentColor = Theme.Mapped.Text.Active,
                disabledContainerColor = Theme.Mapped.Success.Disabled,
                disabledContentColor = Theme.Mapped.Success.TextDisabled
            )

            ERROR -> CustomIconButtonColors(
                containerColor = Theme.Mapped.Error.Main,
                contentColor = Theme.Mapped.Text.Active,
                disabledContainerColor = Theme.Mapped.Error.Disabled,
                disabledContentColor = Theme.Mapped.Error.TextDisabled
            )

            WARNING -> CustomIconButtonColors(
                containerColor = Theme.Mapped.Warning.Main,
                contentColor = Theme.Mapped.Text.Active,
                disabledContainerColor = Theme.Mapped.Warning.Disabled,
                disabledContentColor = Theme.Mapped.Warning.TextDisabled
            )

            INFO -> CustomIconButtonColors(
                containerColor = Theme.Mapped.Info.Main,
                contentColor = Theme.Mapped.Text.Active,
                disabledContainerColor = Theme.Mapped.Info.Disabled,
                disabledContentColor = Theme.Mapped.Info.TextDisabled
            )

            DEFAULT -> CustomIconButtonColors(
                containerColor = Color.Transparent,
                contentColor = Theme.Mapped.Text.Inactive,
                disabledContainerColor = Theme.Mapped.Surface500,
                disabledContentColor = Theme.Mapped.Secondary.TextDisabled
            )

            INHERIT -> CustomIconButtonColors(
                containerColor = Color.Transparent,
                contentColor = Theme.Mapped.Text.Active,
                disabledContainerColor = Color(0x80000000),
                disabledContentColor = Theme.Mapped.Secondary.TextDisabled
            )
        }
    }

    /**
     * Get the default [RoundedCornerShape] for the icon button based on the [CustomIconButtonShape].
     *
     * @param shape the shape of the icon button.
     *
     * @return the [RoundedCornerShape] for the icon button based on the [CustomIconButtonShape].
     *
     * @see [CustomIconButtonShape]
     * @see [CustomIconButtonDefaults]
     */
    val shape: (CustomIconButtonShape) -> RoundedCornerShape = { shape ->
        when (shape) {
            ROUNDED -> RoundedCornerShape(8.dp)
            CIRCULAR -> RoundedCornerShape(999.dp)
        }
    }

    /**
     * Get the default [CustomIconButtonSizeProperties] for the icon button based on the [CustomIconButtonSize].
     *
     * @param size the size of the icon button.
     *
     * @return the [CustomIconButtonSizeProperties] for the icon button based on the [CustomIconButtonSize].
     *
     * @see [CustomIconButtonSize]
     * @see [CustomIconButtonDefaults]
     */
    val sizeProperties: (CustomIconButtonSize) -> CustomIconButtonSizeProperties = { size ->
        when (size) {
            XSMALL -> CustomIconButtonSizeProperties(
                size = 24.dp,
                iconSize = 16.dp,
                contentPadding = 4.dp
            )

            SMALL -> CustomIconButtonSizeProperties(
                size = 32.dp,
                iconSize = 20.dp,
                contentPadding = 6.dp
            )

            MEDIUM -> CustomIconButtonSizeProperties(
                size = 40.dp,
                iconSize = 24.dp,
                contentPadding = 8.dp
            )

            LARGE -> CustomIconButtonSizeProperties(
                size = 48.dp,
                iconSize = 32.dp,
                contentPadding = 8.dp
            )
        }
    }
}
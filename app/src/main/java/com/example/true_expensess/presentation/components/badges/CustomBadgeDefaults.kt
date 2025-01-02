package shortener.truelink.app.presentation.components.bages


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import shortener.truelink.app.ui.theme.customTheme.Theme


/**
 * Represents the container and content colors used in badge in different states.
 *
 * @param containerColor the container color of this chip when enabled
 * @param labelColor the label color of this chip when enabled
 * @param leadingIconContentColor the color of this chip's start icon when enabled
 * @param trailingIconContentColor the color of this chip's end icon when enabled
 * @param disabledContainerColor the container color of this chip when not enabled
 * @param disabledLabelColor the label color of this chip when not enabled
 * @param disabledLeadingIconContentColor the color of this chip's start icon when not enabled
 * @param disabledTrailingIconContentColor the color of this chip's end icon when not enabled
 */
@Immutable
class CustomBadgeColors constructor(
    val containerColor: Color,
    val labelColor: Color,
    val leadingIconContentColor: Color,
    val trailingIconContentColor: Color,
    val disabledContainerColor: Color,
    val disabledLabelColor: Color,
    val disabledLeadingIconContentColor: Color,
    val disabledTrailingIconContentColor: Color
) {
    /**
     * Returns a copy of this ChipColors, optionally overriding some of the values.
     * This uses the Color.Unspecified to mean “use the value from the source”
     */
    fun copy(
        containerColor: Color = this.containerColor,
        labelColor: Color = this.labelColor,
        leadingIconContentColor: Color = this.leadingIconContentColor,
        trailingIconContentColor: Color = this.trailingIconContentColor,
        disabledContainerColor: Color = this.disabledContainerColor,
        disabledLabelColor: Color = this.disabledLabelColor,
        disabledLeadingIconContentColor: Color = this.disabledLeadingIconContentColor,
        disabledTrailingIconContentColor: Color = this.disabledTrailingIconContentColor
    ) = CustomBadgeColors(
        containerColor.takeOrElse { this.containerColor },
        labelColor.takeOrElse { this.labelColor },
        leadingIconContentColor.takeOrElse { this.leadingIconContentColor },
        trailingIconContentColor.takeOrElse { this.trailingIconContentColor },
        disabledContainerColor.takeOrElse { this.disabledContainerColor },
        disabledLabelColor.takeOrElse { this.disabledLabelColor },
        disabledLeadingIconContentColor.takeOrElse { this.disabledLeadingIconContentColor },
        disabledTrailingIconContentColor.takeOrElse { this.disabledTrailingIconContentColor }
    )

    /**
     * Represents the container color for this chip, depending on [enabled].
     *
     * @param enabled whether the chip is enabled
     */
    @Stable
    internal fun containerColor(enabled: Boolean): Color =
        if (enabled) containerColor else disabledContainerColor

    /**
     * Represents the label color for this chip, depending on [enabled].
     *
     * @param enabled whether the chip is enabled
     */
    @Stable
    internal fun labelColor(enabled: Boolean): Color =
        if (enabled) labelColor else disabledLabelColor

    /**
     * Represents the leading icon's content color for this chip, depending on [enabled].
     *
     * @param enabled whether the chip is enabled
     */
    @Stable
    internal fun leadingIconContentColor(enabled: Boolean): Color =
        if (enabled) leadingIconContentColor else disabledLeadingIconContentColor

    /**
     * Represents the trailing icon's content color for this chip, depending on [enabled].
     *
     * @param enabled whether the chip is enabled
     */
    @Stable
    internal fun trailingIconContentColor(enabled: Boolean): Color =
        if (enabled) trailingIconContentColor else disabledTrailingIconContentColor

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is CustomBadgeColors) return false

        if (containerColor != other.containerColor) return false
        if (labelColor != other.labelColor) return false
        if (leadingIconContentColor != other.leadingIconContentColor) return false
        if (trailingIconContentColor != other.trailingIconContentColor) return false
        if (disabledContainerColor != other.disabledContainerColor) return false
        if (disabledLabelColor != other.disabledLabelColor) return false
        if (disabledLeadingIconContentColor != other.disabledLeadingIconContentColor) return false
        if (disabledTrailingIconContentColor != other.disabledTrailingIconContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = containerColor.hashCode()
        result = 31 * result + labelColor.hashCode()
        result = 31 * result + leadingIconContentColor.hashCode()
        result = 31 * result + trailingIconContentColor.hashCode()
        result = 31 * result + disabledContainerColor.hashCode()
        result = 31 * result + disabledLabelColor.hashCode()
        result = 31 * result + disabledLeadingIconContentColor.hashCode()
        result = 31 * result + disabledTrailingIconContentColor.hashCode()

        return result
    }
}

/**
 * Represents the different variants of colors for a badge.
 *
 * @property PRIMARY The primary variant of badge colors.
 * @property SECONDARY The secondary variant of badge colors.
 * @property SUCCESS The success variant of badge colors.
 * @property SURFACE The surface variant of badge colors.
 * @property WARNING The warning variant of badge colors.
 * @property ERROR The error variant of badge colors.
 * @property INFO The info variant of badge colors.
 *
 */
enum class CustomBadgeColorVariant {
    PRIMARY,
    SECONDARY,
    SURFACE,
    SUCCESS,
    WARNING,
    ERROR,
    INFO
}

/**
 * Represents the different sizes of a badge.
 *
 * @property XSMALL The extra small size of a badge.
 * @property SMALL The small size of a badge.
 * @property MEDIUM The medium size of a badge.
 * @property LARGE The large size of a badge.
 */
enum class BadgeSize {
    XSMALL,
    SMALL,
    MEDIUM,
    LARGE
}

/**
 * Represents the dynamic properties of a badge according to its size and label presence.
 *
 * @property contentPadding the padding of the badge content.
 * @property iconSize the size of the badge icon.
 * @property textStyle the text style of the badge label.
 * @property minHeight the minimum height of the badge.
 * @property minWidth the minimum width of the badge.
 */
data class BadgeDynamicProperties(
    val contentPadding: PaddingValues? = null,
    val iconSize: Dp? = null,
    val textStyle: TextStyle? = null,
    val minHeight: Dp = 16.dp,
    val minWidth: Dp = 16.dp
)

/**
 * The default values for a badge.
 *
 * @property shape the default shape of a badge.
 * @property colors get the default colors for a badge based on the variant.
 * @property dynamicProperties get the dynamic properties of a badge based on its size and label presence.
 *
 * @see CustomBadgeColors
 * @see CustomBadgeColorVariant
 * @see BadgeSize
 * @see BadgeDynamicProperties
 *
 */
object CustomBadgeDefaults {

    /**
     * The default shape of a badge.
     */
    val shape = RoundedCornerShape(50)

    /**
     * Get the default colors for a badge based on the [variant].
     *
     * @param variant the variant of badge colors
     *
     * @return the default [CustomBadgeColors] for a badge.
     *
     * @see CustomBadgeColors
     * @see CustomBadgeColorVariant
     *
     */
    val colors: @Composable (CustomBadgeColorVariant) -> CustomBadgeColors = { variant ->
        when (variant) {
            CustomBadgeColorVariant.PRIMARY -> CustomBadgeColors(
                containerColor = Theme.Mapped.Primary.Main,
                labelColor = Theme.Mapped.Primary.TextMain,
                leadingIconContentColor = Theme.Mapped.Primary.TextMain,
                trailingIconContentColor = Theme.Mapped.Primary.TextMain,
                disabledContainerColor = Theme.Mapped.Primary.Disabled,
                disabledLabelColor = Theme.Mapped.Primary.TextDisabled,
                disabledLeadingIconContentColor = Theme.Mapped.Primary.TextDisabled,
                disabledTrailingIconContentColor = Theme.Mapped.Primary.TextDisabled
            )

            CustomBadgeColorVariant.SECONDARY -> CustomBadgeColors(
                containerColor = Theme.Mapped.Secondary.Main,
                labelColor = Theme.Mapped.Secondary.TextMain,
                leadingIconContentColor = Theme.Mapped.Secondary.TextMain,
                trailingIconContentColor = Theme.Mapped.Secondary.TextMain,
                disabledContainerColor = Theme.Mapped.Secondary.Disabled,
                disabledLabelColor = Theme.Mapped.Secondary.TextDisabled,
                disabledLeadingIconContentColor = Theme.Mapped.Secondary.TextDisabled,
                disabledTrailingIconContentColor = Theme.Mapped.Secondary.TextDisabled
            )

            CustomBadgeColorVariant.SURFACE -> CustomBadgeColors(
                containerColor = Theme.Mapped.Surface500,
                labelColor = Theme.Mapped.Text.Active,
                leadingIconContentColor = Theme.Mapped.Text.Active,
                trailingIconContentColor = Theme.Mapped.Text.Active,
                disabledContainerColor = Theme.Mapped.Surface800,
                disabledLabelColor = Theme.Mapped.Text.Disabled,
                disabledLeadingIconContentColor = Theme.Mapped.Text.Disabled,
                disabledTrailingIconContentColor = Theme.Mapped.Text.Disabled
            )

            CustomBadgeColorVariant.SUCCESS -> CustomBadgeColors(
                containerColor = Theme.Mapped.Success.Main,
                labelColor = Theme.Mapped.Success.TextMain,
                leadingIconContentColor = Theme.Mapped.Success.TextMain,
                trailingIconContentColor = Theme.Mapped.Success.TextMain,
                disabledContainerColor = Theme.Mapped.Success.Disabled,
                disabledLabelColor = Theme.Mapped.Success.TextDisabled,
                disabledLeadingIconContentColor = Theme.Mapped.Success.TextDisabled,
                disabledTrailingIconContentColor = Theme.Mapped.Success.TextDisabled
            )

            CustomBadgeColorVariant.WARNING -> CustomBadgeColors(
                containerColor = Theme.Mapped.Warning.Main,
                labelColor = Theme.Mapped.Warning.TextMain,
                leadingIconContentColor = Theme.Mapped.Warning.TextMain,
                trailingIconContentColor = Theme.Mapped.Warning.TextMain,
                disabledContainerColor = Theme.Mapped.Warning.Disabled,
                disabledLabelColor = Theme.Mapped.Warning.TextDisabled,
                disabledLeadingIconContentColor = Theme.Mapped.Warning.TextDisabled,
                disabledTrailingIconContentColor = Theme.Mapped.Warning.TextDisabled
            )

            CustomBadgeColorVariant.ERROR -> CustomBadgeColors(
                containerColor = Theme.Mapped.Error.Main,
                labelColor = Theme.Mapped.Error.TextMain,
                leadingIconContentColor = Theme.Mapped.Error.TextMain,
                trailingIconContentColor = Theme.Mapped.Error.TextMain,
                disabledContainerColor = Theme.Mapped.Error.Disabled,
                disabledLabelColor = Theme.Mapped.Error.TextDisabled,
                disabledLeadingIconContentColor = Theme.Mapped.Error.TextDisabled,
                disabledTrailingIconContentColor = Theme.Mapped.Error.TextDisabled
            )

            CustomBadgeColorVariant.INFO -> CustomBadgeColors(
                containerColor = Theme.Mapped.Info.Main,
                labelColor = Theme.Mapped.Info.TextMain,
                leadingIconContentColor = Theme.Mapped.Info.TextMain,
                trailingIconContentColor = Theme.Mapped.Info.TextMain,
                disabledContainerColor = Theme.Mapped.Info.Disabled,
                disabledLabelColor = Theme.Mapped.Info.TextDisabled,
                disabledLeadingIconContentColor = Theme.Mapped.Info.TextDisabled,
                disabledTrailingIconContentColor = Theme.Mapped.Info.TextDisabled
            )
        }
    }

    /**
     * Get the dynamic properties of a badge based on its [BadgeSize] and [label] presence.
     *
     * @param size the size of the badge
     * @param label whether the badge has a label or not
     *
     * @return the [BadgeDynamicProperties] of a badge.
     *
     * @see BadgeDynamicProperties
     * @see BadgeSize
     *
     */
    val dynamicProperties: @Composable (BadgeSize, Boolean) -> BadgeDynamicProperties =
        { size, label ->
            when (label) {
                /* label variant */
                true -> when (size) {
                    BadgeSize.XSMALL -> BadgeDynamicProperties(
                        contentPadding = PaddingValues(
                            start = 4.dp,
                            end = 4.dp,
                        ),
                        textStyle = Theme.Typography.l4.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        iconSize = 12.dp,
                        minHeight = 16.dp,
                        minWidth = 16.dp
                    )

                    BadgeSize.SMALL -> BadgeDynamicProperties(
                        contentPadding = PaddingValues(
                            start = 6.dp,
                            end = 6.dp,
                            top = 2.dp,
                            bottom = 2.dp
                        ),
                        textStyle = Theme.Typography.l3,
                        iconSize = 12.dp,
                        minHeight = 20.dp,
                        minWidth = 20.dp
                    )

                    BadgeSize.MEDIUM -> BadgeDynamicProperties(
                        contentPadding = PaddingValues(
                            start = 6.dp,
                            end = 6.dp,
                            top = 2.dp,
                            bottom = 2.dp
                        ),
                        textStyle = Theme.Typography.l2,
                        iconSize = 16.dp,
                        minHeight = 24.dp,
                        minWidth = 24.dp
                    )

                    BadgeSize.LARGE -> BadgeDynamicProperties(
                        contentPadding = PaddingValues(
                            start = 8.dp,
                            end = 8.dp,
                            top = 4.dp,
                            bottom = 4.dp
                        ),
                        textStyle = Theme.Typography.l1.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        iconSize = 20.dp,
                        minHeight = 32.dp,
                        minWidth = 32.dp
                    )
                }
                /* end label variant */

                /* no label variant */
                false -> BadgeDynamicProperties()
            }
        }
}
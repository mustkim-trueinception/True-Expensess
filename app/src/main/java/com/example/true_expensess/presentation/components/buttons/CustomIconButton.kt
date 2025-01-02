package ai.truelink.app.presentation.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import shortener.truelink.app.presentation.components.image.DynamicImage
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization

/**
 * A custom icon button that can be used to display an icon with a custom shape, size, and color.
 *
 * Example usage:
 *
 * ```
 * CustomIconButton(
 *     onClick = { /* Handle button click */ },
 *     icon = DynamicImageSource.Local(R.drawable.ic_loading),
 *     colors = CustomIconButtonDefaults.colors(CustomIconButtonColorVariant.PRIMARY),
 *     size = CustomIconButtonSize.LARGE,
 *     shape = CustomIconButtonDefaults.shape(CustomIconButtonShape.CIRCULAR),
 *     // enabled = false,
 * )
 * ```
 *
 * @param onClick The callback that will be called when the button is clicked.
 * @param modifier The modifier to be applied to the button.
 * @param imageModifier The modifier to be applied to the icon.
 * @param enabled Whether the button is enabled or not. If the button is disabled, it will not respond to clicks.
 * {@default true}
 * @param colors The colors to be used for the button. {@default CustomIconButtonDefaults.colors(CustomIconButtonColorVariant.DEFAULT)}
 * use [CustomIconButtonColors] to customize the colors.
 * @param shape The shape of the button. {@default CustomIconButtonDefaults.shape(CustomIconButtonShape.ROUNDED)}
 * @param size The size of the button. {@default CustomIconButtonSize.MEDIUM}
 * @param icon The icon to be displayed on the button. Provide an [DynamicImageSource] to display an icon.
 *
 * @see [CustomIconButtonColors]
 * @see [CustomIconButtonDefaults]
 * @see [CustomIconButtonSize]
 * @see [DynamicImageSource]
 * @see [CustomIconButtonShape]
 * @see [CustomIconButtonColorVariant]
 * @see [CustomIconButtonDefaults]
 * @see [DynamicImage]
 *
 * @author Deepak Yadu @deepak404found
 */
@Composable
fun CustomIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CustomIconButtonColors = CustomIconButtonDefaults.colors(CustomIconButtonColorVariant.DEFAULT),
    shape: RoundedCornerShape = CustomIconButtonDefaults.shape(CustomIconButtonShape.ROUNDED),
    size: CustomIconButtonSize = CustomIconButtonSize.MEDIUM,
    icon: DynamicImageSource,
) {
    val sizeProps = CustomIconButtonDefaults.sizeProperties(size)
    Box(
        modifier = modifier
//            .minimumInteractiveComponentSize()
            .background(
                color = colors.containerColor(enabled),
                shape = shape,
            )
            .clip(shape)
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
            )
            .padding(sizeProps.contentPadding)
            .size(sizeProps.size),
        contentAlignment = Alignment.Center
    ) {
        val contentColor = colors.contentColor(enabled)
        CompositionLocalProvider(LocalContentColor provides contentColor, content = {
            DynamicImage(
                imageSource = icon,
                customization = ImageCustomization.Default.copy(
                    modifier = imageModifier.size(
                        sizeProps.iconSize
                    )
                )
            )
        })
    }
}
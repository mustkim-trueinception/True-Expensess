package ai.truelink.app.presentation.components.images

import ai.truelink.app.presentation.components.images.AvatarSize.LARGE
import ai.truelink.app.presentation.components.images.AvatarSize.MEDIUM
import ai.truelink.app.presentation.components.images.AvatarSize.SMALL
import ai.truelink.app.ui.customTheme.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import shortener.truelink.app.presentation.components.bages.BadgeSize
import shortener.truelink.app.presentation.components.bages.CustomBadge
import shortener.truelink.app.presentation.components.image.DynamicImage
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization

/**
 * AvatarSize is an enum class that defines the size of the avatar.
 *
 * @property SMALL The avatar will be small.
 * @property MEDIUM The avatar will be medium.
 * @property LARGE The avatar will be large.
 *
 * @see [Avatar]
 */
enum class AvatarSize {
    SMALL,
    MEDIUM,
    LARGE
}

/**
 * Avatar is a composable that displays an avatar image or alt text.
 *
 * @param modifier Modifier to be applied to the layout.
 * @param imageSource The source of the image to be displayed.
 * if null, altText will be displayed.
 * @param altText The text to be displayed if imageSource is null.
 * if null, a box with the background color will be displayed.
 * @param size The size of the avatar. Default is [MEDIUM].
 * @param imageCustomization Customization options for the image. Default is [ImageCustomization.Default].
 * @param badgeCount The count to be displayed on the badge.
 *
 * @see [AvatarSize]
 * @see [ImageCustomization]
 * @see [DynamicImageSource]
 * @see [CustomBadge]
 *
 * @author Deepak Yadu @deepak404found
 */
@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    imageSource: DynamicImageSource? = null,
    altText: String? = null,
    size: AvatarSize = MEDIUM,
    imageCustomization: ImageCustomization = ImageCustomization.Default,
    badgeCount: Int? = null,
    onClick: (() -> Unit)? = null
) {
    val shape = RoundedCornerShape(50)

    /* main stack */
    BadgedBox(
        badge = {
            if (badgeCount != null) {
                CustomBadge(
                    label = badgeCount.toString(),
                    size = (when (size) {
                        SMALL -> BadgeSize.XSMALL
                        MEDIUM -> BadgeSize.XSMALL
                        LARGE -> BadgeSize.SMALL
                    }),
                    modifier = Modifier
                        .offset(
                            x = (
                                    when (size) {
                                        SMALL -> (-4).dp
                                        MEDIUM -> (-4).dp
                                        LARGE -> (-10).dp
                                    }
                                    ), y = 0.dp
                        )
                )
            }
        },
        modifier = Modifier

            .let {
                if (onClick != null) it.clickable { onClick() } else it
            }
    )
    {
        /* image box */
        if (imageSource != null) {
            DynamicImage(
                imageSource = imageSource,
                description = "Avatar",
                customization = imageCustomization.copy(
                    tint = Theme.Mapped.Text.Inactive,
                    modifier = modifier.clip(shape = CircleShape)
                        .size(
                            when (size) {
                                SMALL -> 32.dp
                                MEDIUM -> 40.dp
                                LARGE -> 56.dp
                            }
                        )
                )
            )
        }
        /* end image box */

        /* alt text box */
        if (imageSource == null && altText != null)
            Box(
                modifier = modifier

                    .size(
                        when (size) {
                            SMALL -> 32.dp
                            MEDIUM -> 40.dp
                            LARGE -> 56.dp
                        }
                    )
                    .background(Theme.Mapped.Primary.Main)
            ) {
                Text(
                    text = altText,
                    style = (when (size) {
                        SMALL -> Theme.Typography.l3
                        MEDIUM -> Theme.Typography.l2
                        LARGE -> Theme.Typography.h4
                    }),
                    fontWeight = FontWeight.Medium,
                    color = Theme.Mapped.Primary.TextMain,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        /* end alt text box */
    }
    /* end main stack */
}


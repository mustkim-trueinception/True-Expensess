package shortener.truelink.app.presentation.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.true_expensess.presentation.components.image.DynamicImage
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization


/**
 * A customizable `CustomButton` Composable that can display text, optional leading (start) and trailing (end) icons,
 * and can be styled with different button variants (filled or outlined).
 *
 * Example usages:
 * ```
 * CustomButton(
 *      text = "New",
 *      onClick = { /*TODO*/ },
 *      color = CustomButtonColors.DefaultColors(ButtonColorType.PRIMARY),
 *  )
 *  ```
 *
 *  ```
 * CustomButton(
 *      text = "Custom Button",
 *      onClick = { /*TODO*/ },
 *      // enabled = false,
 *      shape = CustomButtonDefaults.buttonShape(ButtonShapeType.ROUNDED),
 *      color = CustomButtonColors.DefaultColors(ButtonColorType.SUCCESS),
 *      sizeProp = CustomButtonDefaults.buttonSize(ButtonSizeType.MEDIUM),
 *      endIcon = { width, height ->
 *          Icon(
 *              modifier = Modifier.size(width.dp, height.dp),
 *              imageVector = Icons.Default.Add,
 *              contentDescription = null
 *          )
 *      },
 *      startIcon = { width, height ->
 *          Icon(
 *              modifier = Modifier.size(width.dp, height.dp),
 *              imageVector = Icons.Default.Add,
 *              contentDescription = null
 *          )
 *      }
 * )
 *  ```
 *
 * @param containerModifier Modifier applied to the button layout.
 * @param colors Custom button colors for styling the button.
 * @param text The label or text displayed on the button.
 * @param enabled Whether the button is enabled or not. If false, the button will appear visually disabled and will not respond to user input.
 * @param onClick The callback triggered when the button is clicked.
 * @param shape The shape of the button.
 *  You can use default shapes from [CustomButtonDefaults] or custom shapes using [RoundedCornerShape].
 *  Default is [ButtonShapeType.ROUNDED].
 * @param sizeProp The size properties of the button.
 * You can use default sizes from [CustomButtonDefaults] or custom sizes using [ButtonSizeProperties].
 * Default is [ButtonSizeType.MEDIUM].
 * @param horizontalArrangement The horizontal arrangement of the button content.
 * @param startIcon An optional leading icon displayed before the text.
 * @param endIcon An optional trailing icon displayed after the text.
 *
 * @see [ButtonShapeType]
 * @see [ButtonSizeType]
 * @see [ButtonSizeProperties]
 * @see [CustomButtonDefaults]
 *
 *
 * @author Deepak Yadu @deepak404found
 */
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    containerModifier: Modifier = Modifier,
    colors: ButtonColors = CustomButtonDefaults.filledButtonColors(type = ButtonColorType.PRIMARY),
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
    endLoading: Boolean = false,
    startLoading: Boolean = false,
    shape: RoundedCornerShape = CustomButtonDefaults.buttonShape(ButtonShapeType.ROUNDED),
    sizeProp: ButtonSizeProperties = CustomButtonDefaults.buttonSize(ButtonSizeType.MEDIUM),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(
        8.dp, Alignment.CenterHorizontally
    ),
    startIcon: DynamicImageSource? = null,
    customizeStartIcon: ImageCustomization = ImageCustomization(
        modifier = Modifier.requiredSize(sizeProp.iconSize),
        tint = colors.contentColor
    ),
    endIcon: DynamicImageSource? = null,
    customizeEndIcon: ImageCustomization = ImageCustomization(
        modifier = Modifier.requiredSize(sizeProp.iconSize),
        tint = colors.contentColor
    ),
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        contentPadding = sizeProp.padding,
        shape = shape,
        colors = colors,
        border = null,
        modifier = modifier
            .defaultMinSize(
                minWidth = sizeProp.minWidth,
                minHeight = sizeProp.minHeight
            ),
    ) {
        Row(
            modifier = containerModifier,
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (startLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(sizeProp.iconSize),
                    color = colors.contentColor
                )
            }
            if (startIcon != null) {
                DynamicImage(
                    imageSource = startIcon,
                    customization = customizeStartIcon
                )
            }
            Text(
                text = text,
                style = TextStyle(
                    fontSize = sizeProp.textStyle.fontSize,
                    fontWeight = sizeProp.textStyle.fontWeight,
                    letterSpacing = sizeProp.textStyle.letterSpacing,
                    lineHeight = sizeProp.textStyle.lineHeight,
                ),
            )
            if (endIcon != null) {
                DynamicImage(
                    imageSource = endIcon,
                    customization = customizeEndIcon
                )
            }
            if (endLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(sizeProp.iconSize),
                    color = colors.contentColor
                )
            }
        }
    }
}
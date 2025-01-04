package ai.truelink.app.presentation.components.inputFields

import ai.truelink.app.ui.customTheme.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

enum class InputFieldVariant {
    STANDARD,
    OUTLINED,
}


/**
 *
 * Text fields allow users to enter text into a UI. They typically appear in forms and dialogs.
 * Filled text fields have more visual emphasis than outlined text fields, making them stand out
 * when surrounded by other content and components.
 *
 * Example usages:
 *
 * - Outlined text field:
 * ```
 * InputField(
 *     value = input.value,
 *     onValueChange = { input.value = it },
 *     placeholder = "Enter your name",
 *     label = "Name",
 *     isError = true,
 *     // isSuccess = true,
 *     helperText = "This is an helper",
 *     isRequired = true,
 *     startIcon = {
 *         Icon(
 *             modifier = Modifier.size(20.dp),
 *             imageVector = Icons.Default.Add,
 *             contentDescription = null
 *         )
 *     },
 *     endIcon = {
 *         Icon(
 *             modifier = Modifier.size(20.dp),
 *             imageVector = Icons.Default.Add,
 *             contentDescription = null
 *         )
 *     },
 *     prefixText = "$",
 *     inlined = true,
 *     enabled = true,
 * )
 *  ```
 *
 * - Standard text field:
 *
 * ```
 * InputField(
 *     inlined = true,
 *     variant = InputFieldVariant.STANDARD,
 *     value = input.value,
 *     onValueChange = { input.value = it },
 *     placeholder = "Enter your name",
 *     label = "Name",
 *     // isError = true,
 *     isSuccess = true,
 *     helperText = "This is an helper",
 *     isRequired = true,
 *     prefixText = "$",
 *     startIcon = {
 *         Icon(
 *             modifier = Modifier.width(20.dp),
 *             imageVector = Icons.Default.Add,
 *             contentDescription = null
 *         )
 *     },
 *     endIcon = {
 *         Icon(
 *             modifier = Modifier.size(20.dp),
 *             imageVector = Icons.Default.Add,
 *             contentDescription = null
 *         )
 *     },
 *     enabled = false,
 * )
 * ```
 *
 * @param value the input [TextFieldValue] to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates values in
 * @param label the label text to be shown in the text field
 * @param placeholder the placeholder text to be shown in the text field
 * @param helperText the helper text to be shown in the text field
 * @param isError whether the text field should be shown in error state
 * @param isSuccess whether the text field should be shown in success state
 * @param isRequired whether the text field is required
 * @param enabled controls the enabled state of this text field. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param startIcon the icon to be shown at the start of the text field
 * @param endIcon the icon to be shown at the end of the text field
 * @param variant the variant of the text field choose from [InputFieldVariant]
 * @param keyboardOptions the keyboard options to be applied to the text field
 * @param keyboardActions the keyboard actions to be applied to the text field
 * @param visualTransformation the visual transformation to be applied to the text field
 * @param singleLine whether the text field should be single line
 * @param maxLines the maximum number of lines the text field should occupy
 * @param modifier the modifier to be applied to the text field
 * @param contentPadding the content padding to be applied to the text field
 * @param colors the colors to be applied to the text field,
 * choose from [OutlinedInputFieldDefaults] or [StandardInputFieldDefaults] based on the variant
 * @param textStyle the text style to be applied to the text field
 * @param prefixText the text to be shown as prefix in the text field. This is only applicable for the outlined variant.
 * If startIcon is provided, it will be shown before the prefix text.
 * @param inlined whether the text field should be shown inline
 * @param size the size of the text field choose from [InputFieldSize].
 *
 *
 * @see InputFieldVariant
 * @see OutlinedInputFieldDefaults
 * @see StandardInputFieldDefaults
 * @see KeyboardOptions
 * @see KeyboardActions
 * @see TextFieldValue
 * @see VisualTransformation
 *
 * @author
 * Deepak Yadu @deepak404found
 */
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    placeholder: String? = null,
    placeholderTextStyle: TextStyle = Theme.Typography.p1,
    helperText: String? = null,
    isError: Boolean? = false,
    isRequired: Boolean? = false,
    isSuccess: Boolean? = false,
    enabled: Boolean = true,
    startIcon: @Composable (() -> Unit)? = null,
    endIcon: @Composable (() -> Unit)? = null,
    variant: InputFieldVariant = InputFieldVariant.OUTLINED,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    shape: Shape? = null,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    limit: Int? = null,
    colors: TextFieldColors = when (variant) {
        InputFieldVariant.STANDARD -> isSuccess?.let { if (it) StandardInputFieldDefaults.SuccessColors else StandardInputFieldDefaults.DefaultColors }
            ?: StandardInputFieldDefaults.DefaultColors

        InputFieldVariant.OUTLINED -> isSuccess?.let { if (it) OutlinedInputFieldDefaults.SuccessColors else OutlinedInputFieldDefaults.DefaultColors }
            ?: OutlinedInputFieldDefaults.DefaultColors
    },
    textStyle: TextStyle = Theme.Typography.l1,
    prefixText: String? = null,
    inlined: Boolean = false,
    size: InputFieldSize = InputFieldSize.SMALL,
    contentPadding: PaddingValues = OutlinedInputFieldDefaults.contentPadding(
        prefixText != null && variant == InputFieldVariant.OUTLINED,
        size,
    ),
    readOnly: Boolean = false,
    info: String? = null,
) {

    /* main stack */
    when (inlined) {
        /* inline stack */
        true ->
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                /* header and text field */
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    /* header */
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        /* label */
                        if (label != null)
                            Text(
                                text = label,
                                style = Theme.Typography.p2,
                                color = enabled.let { if (it) colors.focusedLabelColor else colors.disabledLabelColor }
                            )

                        /* info */

                        /* required */
                        if (isRequired == true) {
                            Text(
                                text = "*",
                                style = Theme.Typography.l1,
                                color = Theme.System.Error500,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    /* end header */

                    /* text field */
                    SimpleTextField(
                        value = value,
                        onValueChange = {
                            if (limit == null)
                                onValueChange(it)
                            else
                                if (it.length <= limit) {
                                    onValueChange(it)
                                }
                        },
                        placeholder = {
                            Text(
                                text = placeholder ?: "",
                                color = colors.unfocusedPlaceholderColor,
                                style = placeholderTextStyle
                            )
                        },
                        visualTransformation = visualTransformation,
                        isError = isError ?: false,
                        enabled = enabled,
                        singleLine = singleLine,
                        maxLines = maxLines,
                        keyboardOptions = keyboardOptions,
                        keyboardActions = keyboardActions,
                        leadingIcon = if (prefixText != null && variant == InputFieldVariant.OUTLINED) null else startIcon,
                        trailingIcon = endIcon,
                        colors = colors,
                        shape = shape ?: variant.let {
                            when (it) {
                                InputFieldVariant.STANDARD -> StandardInputFieldDefaults.shape
                                InputFieldVariant.OUTLINED -> OutlinedInputFieldDefaults.shape
                            }
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        variant = variant,
                        contentPadding = contentPadding,
                        textStyle = textStyle,
                        prefix = {
                            if (prefixText != null && variant == InputFieldVariant.OUTLINED) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(
                                        8.dp,
                                        Alignment.CenterHorizontally
                                    ),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                        .border(
                                            width = 1.dp,
                                            color = Theme.Mapped.Shade600,
                                            shape = RoundedCornerShape(
                                                bottomEnd = 0.dp,
                                                bottomStart = 8.dp,
                                                topEnd = 0.dp,
                                                topStart = 8.dp
                                            )
                                        )
                                        .width(
                                            size.let {
                                                when (it) {
                                                    InputFieldSize.SMALL -> 58.dp
                                                    InputFieldSize.MEDIUM -> 71.dp
                                                }
                                            }
                                        )
                                        .height(
                                            size.let {
                                                when (it) {
                                                    InputFieldSize.SMALL -> 40.dp
                                                    InputFieldSize.MEDIUM -> 48.dp
                                                }
                                            }
                                        )
                                        .background(
                                            color = Theme.Mapped.Shade800,
                                            shape = RoundedCornerShape(
                                                bottomEnd = 0.dp,
                                                bottomStart = 8.dp,
                                                topEnd = 0.dp,
                                                topStart = 8.dp
                                            )
                                        )
                                        .padding(
                                            size.let {
                                                when (it) {
                                                    InputFieldSize.SMALL -> PaddingValues(
                                                        horizontal = 10.dp,
                                                        vertical = 8.dp
                                                    )

                                                    InputFieldSize.MEDIUM -> PaddingValues(
                                                        horizontal = 16.dp,
                                                        vertical = 12.dp
                                                    )
                                                }
                                            }
                                        )
                                ) {
                                    /* start icon */
                                    if (startIcon != null) {
                                        startIcon()
                                    }

                                    Text(
                                        text = prefixText,
                                        style = Theme.Typography.l1
                                    )
                                }
                            }
                        },
                        suffix = {
                            if (limit != null)
                                Text(
                                    text = "${value.length}/$limit",
                                    style = Theme.Typography.l1
                                )
                        },
                    )
                    /* end text field */
                }
                /* end header and text field */

                /* helper text */
                if (helperText != null) {
                    Text(
                        text = helperText,
                        style = Theme.Typography.l1,
                        color = when {
                            isError == true -> colors.errorSupportingTextColor
                            enabled == false -> colors.disabledSupportingTextColor
                            else -> colors.focusedSupportingTextColor
                        }
                    )
                }
                /* end helper text */

            }
        /* end inline stack */

        /* block stack */
        false ->
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                /* header */
                if (label != null) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        /* label */
                        Text(
                            text = label,
                            style = Theme.Typography.p2,
                            color = enabled.let { if (it) colors.focusedLabelColor else colors.disabledLabelColor }
                        )

                        /* info */

                        /* required */
                        if (isRequired == true) {
                            Text(
                                text = "*",
                                style = Theme.Typography.l1,
                                color = Theme.System.Error500,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                /* end header */

                /* text field */
                SimpleTextField(
                    value = value,
                    onValueChange = {
                        if (limit == null)
                            onValueChange(it)
                        else
                            if (it.length <= limit) {
                                onValueChange(it)
                            }
                    },
                    placeholder = {
                        Text(
                            text = placeholder ?: "",
                            color = colors.unfocusedPlaceholderColor,
                            style = placeholderTextStyle
                        )
                    },
                    visualTransformation = visualTransformation,
                    isError = isError ?: false,
                    enabled = enabled,
                    singleLine = singleLine,
                    maxLines = maxLines,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    leadingIcon = if (prefixText != null && variant == InputFieldVariant.OUTLINED) null else startIcon,
                    trailingIcon = endIcon,
                    colors = colors,
                    shape = shape ?: variant.let {
                        when (it) {
                            InputFieldVariant.STANDARD -> StandardInputFieldDefaults.shape
                            InputFieldVariant.OUTLINED -> OutlinedInputFieldDefaults.shape
                        }
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .defaultMinSize(
                            minHeight = 40.dp
                        ),
                    variant = variant,
                    contentPadding = contentPadding,
                    textStyle = textStyle.copy(
                        color = if (enabled) Theme.Mapped.Text.Active else Theme.Mapped.Text.Disabled
                    ),
                    readOnly = readOnly,
                    prefix = {
                        if (prefixText != null && variant == InputFieldVariant.OUTLINED) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.CenterHorizontally
                                ),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .border(
                                        width = 1.dp,
                                        color = Theme.Mapped.Shade600,
                                        shape = RoundedCornerShape(
                                            bottomEnd = 0.dp,
                                            bottomStart = 8.dp,
                                            topEnd = 0.dp,
                                            topStart = 8.dp
                                        )
                                    )
                                    .width(
                                        size.let {
                                            when (it) {
                                                InputFieldSize.SMALL -> 58.dp
                                                InputFieldSize.MEDIUM -> 71.dp
                                            }
                                        }
                                    )
                                    .height(
                                        size.let {
                                            when (it) {
                                                InputFieldSize.SMALL -> 40.dp
                                                InputFieldSize.MEDIUM -> 48.dp
                                            }
                                        }
                                    )
                                    .background(
                                        color = Theme.Mapped.Shade800,
                                        shape = RoundedCornerShape(
                                            bottomEnd = 0.dp,
                                            bottomStart = 8.dp,
                                            topEnd = 0.dp,
                                            topStart = 8.dp
                                        )
                                    )
                                    .padding(
                                        size.let {
                                            when (it) {
                                                InputFieldSize.SMALL -> PaddingValues(
                                                    horizontal = 10.dp,
                                                    vertical = 8.dp
                                                )

                                                InputFieldSize.MEDIUM -> PaddingValues(
                                                    horizontal = 16.dp,
                                                    vertical = 12.dp
                                                )
                                            }
                                        }
                                    )
                            ) {
                                /* start icon */
                                if (startIcon != null) {
                                    startIcon()
                                }

                                Text(
                                    text = prefixText,
                                    style = Theme.Typography.l1
                                )
                            }
                        }
                    },
                    suffix = {
                        if (limit != null)
                            Text(
                                text = "${value.length}/$limit",
                                style = Theme.Typography.l1
                            )
                    },
                )
                /* end text field */

                /* helper text */
                if (helperText != null) {
                    Text(
                        text = helperText,
                        style = Theme.Typography.l1,
                        color = when {
                            isError == true -> colors.errorSupportingTextColor
                            enabled == false -> colors.disabledSupportingTextColor
                            else -> colors.focusedSupportingTextColor
                        }
                    )
                }
                /* end helper text */

            }
        /* end block stack */
    }
    /* end main stack */
}

/**
 * A customized text field, created using [BasicTextField] and [TextFieldDefaults.DecorationBox]
 * or [OutlinedTextFieldDefaults.DecorationBox] based on the variant.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = Theme.Typography.l1,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldDefaults.shape,
    colors: TextFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
    ),
    contentPadding: PaddingValues = PaddingValues(
        start = 12.dp,
        end = 12.dp,
        top = 4.dp,
        bottom = 4.dp
    ),
    variant: InputFieldVariant = InputFieldVariant.OUTLINED,
    cursorBrush: SolidColor = SolidColor(MaterialTheme.colorScheme.primary),
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
) {
    /* BasicTextField */
    BasicTextField(
        value = value,
        modifier = modifier,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        cursorBrush = cursorBrush,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        singleLine = singleLine,
        maxLines = maxLines
    ) { innerTextField ->
        /* decoration box variant */
        when (variant) {
            /* filled variant */
            InputFieldVariant.STANDARD ->
                TextFieldDefaults.DecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    prefix = prefix,
                    suffix = suffix,
                    enabled = enabled,
                    singleLine = singleLine,
                    visualTransformation = visualTransformation,
                    interactionSource = interactionSource,
                    isError = isError,
                    placeholder = placeholder,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    colors = colors,
                    contentPadding = contentPadding,
                    container = {
                        TextFieldDefaults.ContainerBox(
                            enabled = enabled,
                            isError = isError,
                            interactionSource = interactionSource,
                            colors = colors,
                            shape = shape,
                        )
                    },
                )

            /* outlined variant */
            InputFieldVariant.OUTLINED ->
                OutlinedTextFieldDefaults.DecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    enabled = enabled,
                    prefix = prefix,
                    suffix = suffix,
                    singleLine = singleLine,
                    visualTransformation = visualTransformation,
                    interactionSource = interactionSource,
                    isError = isError,
                    placeholder = placeholder,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    colors = colors,
                    contentPadding = contentPadding,
                    container = {
                        OutlinedTextFieldDefaults.ContainerBox(
                            enabled = enabled,
                            isError = isError,
                            interactionSource = interactionSource,
                            colors = colors,
                            shape = shape,
                            focusedBorderThickness = OutlinedTextFieldDefaults.FocusedBorderThickness,
                            unfocusedBorderThickness = OutlinedTextFieldDefaults.UnfocusedBorderThickness,
                        )
                    },
                )
        }
        /* end decoration box variant */
    }
    /* end BasicTextField */
}
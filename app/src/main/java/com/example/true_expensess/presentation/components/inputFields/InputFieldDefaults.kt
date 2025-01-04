package ai.truelink.app.presentation.components.inputFields

import ai.truelink.app.presentation.components.inputFields.InputFieldSize.MEDIUM
import ai.truelink.app.presentation.components.inputFields.InputFieldSize.SMALL
import ai.truelink.app.ui.customTheme.Theme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Size of the input field.
 *
 * @property SMALL Small input field size. Uses smaller padding values (8.dp).
 * @property MEDIUM Medium input field size. Uses larger padding values (12.dp).
 *
 */
enum class InputFieldSize {
    SMALL, MEDIUM
}

/**
 * Default properties for Outlined InputField
 *
 * - DefaultColors: Default colors for the outlined input field
 * - SuccessColors: Success colors for the outlined input field
 *
 */
object OutlinedInputFieldDefaults {

    val shape = RoundedCornerShape(8.dp)


//    if prefix is present, add padding to the end
//    PaddingValues(
//    start = 1.dp,
//    end = 8.dp,
//    top = 1.dp,
//    bottom = 1.dp
//    )

    val contentPadding: (Boolean, InputFieldSize) -> PaddingValues = { isPrefix, size ->
        when (size) {
            SMALL -> PaddingValues(
                start = if (isPrefix) 1.dp else 8.dp,
                top = if (isPrefix) 1.dp else 8.dp,
                bottom = if (isPrefix) 1.dp else 8.dp,
                end = 8.dp,
            )

            MEDIUM -> PaddingValues(
                start = if (isPrefix) 1.dp else 12.dp,
                top = if (isPrefix) 1.dp else 12.dp,
                bottom = if (isPrefix) 1.dp else 12.dp,
                end = 12.dp,
            )
        }
    }


    /**
     * Default colors for the outlined input field.
     *
     * use [OutlinedTextFieldDefaults.colors] to create a custom color scheme
     *
     * @return [TextFieldColors] Default colors for the outlined input field
     */
    val DefaultColors
        @Composable get():TextFieldColors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Theme.Mapped.Text.Active,
            unfocusedTextColor = Theme.Mapped.Text.Inactive,
            disabledTextColor = Theme.Mapped.Text.Disabled,
            errorTextColor = Theme.Mapped.Text.Inactive,

            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,

            focusedBorderColor = Theme.Mapped.Primary.Focused,
            unfocusedBorderColor = Theme.Mapped.Shade600,
            disabledBorderColor = Theme.Mapped.Secondary.Disabled,
            errorBorderColor = Theme.Mapped.BorderError,

            focusedLeadingIconColor = Theme.Mapped.Text.Active,
            unfocusedLeadingIconColor = Theme.Mapped.Text.Inactive,
            disabledLeadingIconColor = Theme.Mapped.Text.Disabled,
            errorLeadingIconColor = Theme.Mapped.Text.Inactive,
            focusedTrailingIconColor = Theme.Mapped.Text.Active,
            unfocusedTrailingIconColor = Theme.Mapped.Text.Inactive,
            disabledTrailingIconColor = Theme.Mapped.Text.Disabled,
            errorTrailingIconColor = Theme.Mapped.Text.Inactive,

            focusedLabelColor = Theme.Mapped.Text.Active,
            unfocusedLabelColor = Theme.Mapped.Text.Active,
            disabledLabelColor = Theme.Mapped.Text.Disabled,
            errorLabelColor = Theme.Mapped.Text.Active,

            focusedPlaceholderColor = Theme.Mapped.Text.Inactive,
            unfocusedPlaceholderColor = Theme.Mapped.Text.Inactive,
            disabledPlaceholderColor = Theme.Mapped.Text.Disabled,
            errorPlaceholderColor = Theme.Mapped.Text.Inactive,

            focusedSupportingTextColor = Theme.Mapped.Text.Inactive,
            unfocusedSupportingTextColor = Theme.Mapped.Text.Inactive,
            disabledSupportingTextColor = Theme.Mapped.Text.Disabled,
            errorSupportingTextColor = Theme.System.Error400,

            focusedPrefixColor = Theme.Mapped.Text.Active,
            unfocusedPrefixColor = Theme.Mapped.Text.Inactive,
            disabledPrefixColor = Theme.Mapped.Text.Disabled,
            errorPrefixColor = Theme.Mapped.Text.Inactive,
            focusedSuffixColor = Theme.Mapped.Text.Active,
            unfocusedSuffixColor = Theme.Mapped.Text.Inactive,
            disabledSuffixColor = Theme.Mapped.Text.Disabled,
            errorSuffixColor = Theme.Mapped.Text.Inactive,
        )

    /**
     * Success colors for the outlined input field. When the input field is in a success state.
     *
     * use [OutlinedTextFieldDefaults.colors] to create a custom color scheme
     *
     * @return [TextFieldColors] Success colors for the outlined input field
     */
    val SuccessColors
        @Composable get() = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Theme.Mapped.Text.Active,
            unfocusedTextColor = Theme.Mapped.Text.Inactive,
            disabledTextColor = Theme.Mapped.Text.Disabled,
            errorTextColor = Theme.Mapped.Text.Inactive,

            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,

            focusedBorderColor = Theme.Mapped.BorderSuccess,
            unfocusedBorderColor = Theme.Mapped.BorderSuccess,
            disabledBorderColor = Theme.Mapped.Secondary.Disabled,
            errorBorderColor = Theme.Mapped.BorderError,

            focusedLeadingIconColor = Theme.Mapped.Text.Active,
            unfocusedLeadingIconColor = Theme.Mapped.Text.Inactive,
            disabledLeadingIconColor = Theme.Mapped.Text.Disabled,
            errorLeadingIconColor = Theme.Mapped.Text.Inactive,
            focusedTrailingIconColor = Theme.Mapped.Text.Active,
            unfocusedTrailingIconColor = Theme.Mapped.Text.Inactive,
            disabledTrailingIconColor = Theme.Mapped.Text.Disabled,
            errorTrailingIconColor = Theme.Mapped.Text.Inactive,

            focusedLabelColor = Theme.Mapped.Text.Active,
            unfocusedLabelColor = Theme.Mapped.Text.Active,
            disabledLabelColor = Theme.Mapped.Text.Disabled,
            errorLabelColor = Theme.Mapped.Text.Active,

            focusedPlaceholderColor = Theme.Mapped.Text.Inactive,
            unfocusedPlaceholderColor = Theme.Mapped.Text.Inactive,
            disabledPlaceholderColor = Theme.Mapped.Text.Disabled,
            errorPlaceholderColor = Theme.Mapped.Text.Inactive,

            focusedSupportingTextColor = Theme.System.Success400,
            unfocusedSupportingTextColor = Theme.Mapped.Text.Inactive,
            disabledSupportingTextColor = Theme.Mapped.Text.Disabled,
            errorSupportingTextColor = Theme.System.Error400,

            focusedPrefixColor = Theme.Mapped.Text.Active,
            unfocusedPrefixColor = Theme.Mapped.Text.Inactive,
            disabledPrefixColor = Theme.Mapped.Text.Disabled,
            errorPrefixColor = Theme.Mapped.Text.Inactive,
            focusedSuffixColor = Theme.Mapped.Text.Active,
            unfocusedSuffixColor = Theme.Mapped.Text.Inactive,
            disabledSuffixColor = Theme.Mapped.Text.Disabled,
            errorSuffixColor = Theme.Mapped.Text.Inactive,
        )


    /**
     * Use this function to create a custom color scheme for the outlined input field.
     * All default colors are provided as parameters, so you can customize only the colors you need.
     * If you don't provide a color, the default color will be used.
     */
    @Composable
    fun customizeDefaultColors(
        focusedTextColor: Color = Theme.Mapped.Text.Active,
        unfocusedTextColor: Color = Theme.Mapped.Text.Inactive,
        disabledTextColor: Color = Theme.Mapped.Text.Disabled,
        errorTextColor: Color = Theme.Mapped.Text.Inactive,

        focusedContainerColor: Color = Color.Transparent,
        unfocusedContainerColor: Color = Color.Transparent,
        disabledContainerColor: Color = Color.Transparent,
        errorContainerColor: Color = Color.Transparent,

        focusedBorderColor: Color = Theme.Mapped.Primary.Focused,
        unfocusedBorderColor: Color = Theme.Mapped.Shade600,
        disabledBorderColor: Color = Theme.Mapped.Secondary.Disabled,
        errorBorderColor: Color = Theme.Mapped.BorderError,

        focusedLeadingIconColor: Color = Theme.Mapped.Text.Active,
        unfocusedLeadingIconColor: Color = Theme.Mapped.Text.Inactive,
        disabledLeadingIconColor: Color = Theme.Mapped.Text.Disabled,
        errorLeadingIconColor: Color = Theme.Mapped.Text.Inactive,
        focusedTrailingIconColor: Color = Theme.Mapped.Text.Active,
        unfocusedTrailingIconColor: Color = Theme.Mapped.Text.Inactive,
        disabledTrailingIconColor: Color = Theme.Mapped.Text.Disabled,
        errorTrailingIconColor: Color = Theme.Mapped.Text.Inactive,

        focusedLabelColor: Color = Theme.Mapped.Text.Active,
        unfocusedLabelColor: Color = Theme.Mapped.Text.Active,
        disabledLabelColor: Color = Theme.Mapped.Text.Disabled,
        errorLabelColor: Color = Theme.Mapped.Text.Active,

        focusedPlaceholderColor: Color = Theme.Mapped.Text.Inactive,
        unfocusedPlaceholderColor: Color = Theme.Mapped.Text.Inactive,
        disabledPlaceholderColor: Color = Theme.Mapped.Text.Disabled,
        errorPlaceholderColor: Color = Theme.Mapped.Text.Inactive,

        focusedSupportingTextColor: Color = Theme.Mapped.Text.Inactive,
        unfocusedSupportingTextColor: Color = Theme.Mapped.Text.Inactive,
        disabledSupportingTextColor: Color = Theme.Mapped.Text.Disabled,
        errorSupportingTextColor: Color = Theme.System.Error400,

        focusedPrefixColor: Color = Theme.Mapped.Text.Active,
        unfocusedPrefixColor: Color = Theme.Mapped.Text.Inactive,
        disabledPrefixColor: Color = Theme.Mapped.Text.Disabled,
        errorPrefixColor: Color = Theme.Mapped.Text.Inactive,
        focusedSuffixColor: Color = Theme.Mapped.Text.Active,
        unfocusedSuffixColor: Color = Theme.Mapped.Text.Inactive,
        disabledSuffixColor: Color = Theme.Mapped.Text.Disabled,
        errorSuffixColor: Color = Theme.Mapped.Text.Inactive,
    ): TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = focusedTextColor,
        unfocusedTextColor = unfocusedTextColor,
        disabledTextColor = disabledTextColor,
        errorTextColor = errorTextColor,

        focusedContainerColor = focusedContainerColor,
        unfocusedContainerColor = unfocusedContainerColor,
        disabledContainerColor = disabledContainerColor,
        errorContainerColor = errorContainerColor,

        focusedBorderColor = focusedBorderColor,
        unfocusedBorderColor = unfocusedBorderColor,
        disabledBorderColor = disabledBorderColor,
        errorBorderColor = errorBorderColor,

        focusedLeadingIconColor = focusedLeadingIconColor,
        unfocusedLeadingIconColor = unfocusedLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        focusedTrailingIconColor = focusedTrailingIconColor,
        unfocusedTrailingIconColor = unfocusedTrailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,

        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unfocusedLabelColor,
        disabledLabelColor = disabledLabelColor,
        errorLabelColor = errorLabelColor,

        focusedPlaceholderColor = focusedPlaceholderColor,
        unfocusedPlaceholderColor = unfocusedPlaceholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        errorPlaceholderColor = errorPlaceholderColor,

        focusedSupportingTextColor = focusedSupportingTextColor,
        unfocusedSupportingTextColor = unfocusedSupportingTextColor,
        disabledSupportingTextColor = disabledSupportingTextColor,
        errorSupportingTextColor = errorSupportingTextColor,

        focusedPrefixColor = focusedPrefixColor,
        unfocusedPrefixColor = unfocusedPrefixColor,
        disabledPrefixColor = disabledPrefixColor,
        errorPrefixColor = errorPrefixColor,
        focusedSuffixColor = focusedSuffixColor,
        unfocusedSuffixColor = unfocusedSuffixColor,
        disabledSuffixColor = disabledSuffixColor,
        errorSuffixColor = errorSuffixColor,
    )

}

/**
 * Default properties for Standard InputField
 *
 * - DefaultColors: Default colors for the standard input field
 * - SuccessColors: Success colors for the standard input field
 *
 */
object StandardInputFieldDefaults {
    val shape = RoundedCornerShape(
        topStart = 6.dp,
        topEnd = 6.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )

    /**
     * Default colors for the standard input field.
     *
     * use [TextFieldDefaults.colors] to create a custom color scheme
     *
     * @return [TextFieldColors] Default colors for the standard input field
     */
    val DefaultColors
        @Composable get() = TextFieldDefaults.colors(
            focusedTextColor = Theme.Mapped.Text.Active,
            unfocusedTextColor = Theme.Mapped.Text.Inactive,
            disabledTextColor = Theme.Mapped.Text.Disabled,
            errorTextColor = Theme.Mapped.Text.Inactive,

            focusedContainerColor = Theme.Mapped.Shade900,
            unfocusedContainerColor = Theme.Mapped.Shade900,
            disabledContainerColor = Theme.Mapped.Secondary.Disabled,
            errorContainerColor = Theme.Mapped.Shade900,

            focusedIndicatorColor = Theme.Mapped.Primary.Focused,
            unfocusedIndicatorColor = Theme.Mapped.Shade600,
            disabledIndicatorColor = Theme.Mapped.Secondary.Disabled,
            errorIndicatorColor = Theme.Mapped.BorderError,

            focusedLabelColor = Theme.Mapped.Text.Active,
            unfocusedLabelColor = Theme.Mapped.Text.Active,
            disabledLabelColor = Theme.Mapped.Text.Disabled,
            errorLabelColor = Theme.Mapped.Text.Active,

            focusedPlaceholderColor = Theme.Mapped.Text.Inactive,
            unfocusedPlaceholderColor = Theme.Mapped.Text.Inactive,
            disabledPlaceholderColor = Theme.Mapped.Text.Disabled,
            errorPlaceholderColor = Theme.Mapped.Text.Inactive,

            focusedSupportingTextColor = Theme.Mapped.Text.Inactive,
            unfocusedSupportingTextColor = Theme.Mapped.Text.Inactive,
            disabledSupportingTextColor = Theme.Mapped.Text.Disabled,
            errorSupportingTextColor = Theme.System.Error400,

            focusedPrefixColor = Theme.Mapped.Text.Active,
            unfocusedPrefixColor = Theme.Mapped.Text.Inactive,
            disabledPrefixColor = Theme.Mapped.Text.Disabled,
            errorPrefixColor = Theme.Mapped.Text.Inactive,
            focusedSuffixColor = Theme.Mapped.Text.Active,
            unfocusedSuffixColor = Theme.Mapped.Text.Inactive,
            disabledSuffixColor = Theme.Mapped.Text.Disabled,
            errorSuffixColor = Theme.Mapped.Text.Inactive,

            focusedLeadingIconColor = Theme.Mapped.Text.Active,
            unfocusedLeadingIconColor = Theme.Mapped.Text.Inactive,
            disabledLeadingIconColor = Theme.Mapped.Text.Disabled,
            errorLeadingIconColor = Theme.Mapped.Text.Inactive,
            focusedTrailingIconColor = Theme.Mapped.Text.Active,
            unfocusedTrailingIconColor = Theme.Mapped.Text.Inactive,
            disabledTrailingIconColor = Theme.Mapped.Text.Disabled,
            errorTrailingIconColor = Theme.Mapped.Text.Inactive,
        )

    /**
     * Success colors for the standard input field. When the input field is in a success state.
     *
     * use [TextFieldDefaults.colors] to create a custom color scheme
     *
     * @return [TextFieldColors] Success colors for the standard input field
     *
     */
    val SuccessColors
        @Composable get() = TextFieldDefaults.colors(
            focusedTextColor = Theme.Mapped.Text.Active,
            unfocusedTextColor = Theme.Mapped.Text.Inactive,
            disabledTextColor = Theme.Mapped.Text.Disabled,
            errorTextColor = Theme.Mapped.Text.Inactive,

            focusedContainerColor = Theme.Mapped.Shade900,
            unfocusedContainerColor = Theme.Mapped.Shade900,
            disabledContainerColor = Theme.Mapped.Secondary.Disabled,
            errorContainerColor = Theme.Mapped.Shade900,

            focusedIndicatorColor = Theme.System.Success400,
            unfocusedIndicatorColor = Theme.System.Success400,
            disabledIndicatorColor = Theme.Mapped.Secondary.Disabled,
            errorIndicatorColor = Theme.System.Error400,

            focusedLabelColor = Theme.Mapped.Text.Active,
            unfocusedLabelColor = Theme.Mapped.Text.Active,
            disabledLabelColor = Theme.Mapped.Text.Disabled,
            errorLabelColor = Theme.Mapped.Text.Active,

            focusedPlaceholderColor = Theme.Mapped.Text.Inactive,
            unfocusedPlaceholderColor = Theme.Mapped.Text.Inactive,
            disabledPlaceholderColor = Theme.Mapped.Text.Disabled,
            errorPlaceholderColor = Theme.Mapped.Text.Inactive,

            focusedSupportingTextColor = Theme.System.Success400,
            unfocusedSupportingTextColor = Theme.Mapped.Text.Inactive,
            disabledSupportingTextColor = Theme.Mapped.Text.Disabled,
            errorSupportingTextColor = Theme.System.Error400,

            focusedPrefixColor = Theme.Mapped.Text.Active,
            unfocusedPrefixColor = Theme.Mapped.Text.Inactive,
            disabledPrefixColor = Theme.Mapped.Text.Disabled,
            errorPrefixColor = Theme.Mapped.Text.Inactive,
            focusedSuffixColor = Theme.Mapped.Text.Active,
            unfocusedSuffixColor = Theme.Mapped.Text.Inactive,
            disabledSuffixColor = Theme.Mapped.Text.Disabled,
            errorSuffixColor = Theme.Mapped.Text.Inactive,

            focusedLeadingIconColor = Theme.Mapped.Text.Active,
            unfocusedLeadingIconColor = Theme.Mapped.Text.Inactive,
            disabledLeadingIconColor = Theme.Mapped.Text.Disabled,
            errorLeadingIconColor = Theme.Mapped.Text.Inactive,
            focusedTrailingIconColor = Theme.Mapped.Text.Active,
            unfocusedTrailingIconColor = Theme.Mapped.Text.Inactive,
            disabledTrailingIconColor = Theme.Mapped.Text.Disabled,
            errorTrailingIconColor = Theme.Mapped.Text.Inactive,
        )

    /**
     * Use this function to create a custom color scheme for the standard input field.
     * All default colors are provided as parameters, so you can customize only the colors you need.
     * If you don't provide a color, the default color will be used.
     */
    @Composable
    fun customizeDefaultColors(
        focusedTextColor: Color = Theme.Mapped.Text.Active,
        unfocusedTextColor: Color = Theme.Mapped.Text.Inactive,
        disabledTextColor: Color = Theme.Mapped.Text.Disabled,
        errorTextColor: Color = Theme.Mapped.Text.Inactive,

        focusedContainerColor: Color = Theme.Mapped.Shade900,
        unfocusedContainerColor: Color = Theme.Mapped.Shade900,
        disabledContainerColor: Color = Theme.Mapped.Secondary.Disabled,
        errorContainerColor: Color = Theme.Mapped.Shade900,

        focusedIndicatorColor: Color = Theme.Mapped.Primary.Focused,
        unfocusedIndicatorColor: Color = Theme.Mapped.Shade600,
        disabledIndicatorColor: Color = Theme.Mapped.Secondary.Disabled,
        errorIndicatorColor: Color = Theme.Mapped.BorderError,

        focusedLabelColor: Color = Theme.Mapped.Text.Active,
        unfocusedLabelColor: Color = Theme.Mapped.Text.Active,
        disabledLabelColor: Color = Theme.Mapped.Text.Disabled,
        errorLabelColor: Color = Theme.Mapped.Text.Active,

        focusedPlaceholderColor: Color = Theme.Mapped.Text.Inactive,
        unfocusedPlaceholderColor: Color = Theme.Mapped.Text.Inactive,
        disabledPlaceholderColor: Color = Theme.Mapped.Text.Disabled,
        errorPlaceholderColor: Color = Theme.Mapped.Text.Inactive,

        focusedSupportingTextColor: Color = Theme.Mapped.Text.Inactive,
        unfocusedSupportingTextColor: Color = Theme.Mapped.Text.Inactive,
        disabledSupportingTextColor: Color = Theme.Mapped.Text.Disabled,
        errorSupportingTextColor: Color = Theme.System.Error400,

        focusedPrefixColor: Color = Theme.Mapped.Text.Active,
        unfocusedPrefixColor: Color = Theme.Mapped.Text.Inactive,
        disabledPrefixColor: Color = Theme.Mapped.Text.Disabled,
        errorPrefixColor: Color = Theme.Mapped.Text.Inactive,
        focusedSuffixColor: Color = Theme.Mapped.Text.Active,
        unfocusedSuffixColor: Color = Theme.Mapped.Text.Inactive,
        disabledSuffixColor: Color = Theme.Mapped.Text.Disabled,
        errorSuffixColor: Color = Theme.Mapped.Text.Inactive,

        focusedLeadingIconColor: Color = Theme.Mapped.Text.Active,
        unfocusedLeadingIconColor: Color = Theme.Mapped.Text.Inactive,
        disabledLeadingIconColor: Color = Theme.Mapped.Text.Disabled,
        errorLeadingIconColor: Color = Theme.Mapped.Text.Inactive,
        focusedTrailingIconColor: Color = Theme.Mapped.Text.Active,
        unfocusedTrailingIconColor: Color = Theme.Mapped.Text.Inactive,
        disabledTrailingIconColor: Color = Theme.Mapped.Text.Disabled,
        errorTrailingIconColor: Color = Theme.Mapped.Text.Inactive,
    ): TextFieldColors = TextFieldDefaults.colors(
        focusedTextColor = focusedTextColor,
        unfocusedTextColor = unfocusedTextColor,
        disabledTextColor = disabledTextColor,
        errorTextColor = errorTextColor,

        focusedContainerColor = focusedContainerColor,
        unfocusedContainerColor = unfocusedContainerColor,
        disabledContainerColor = disabledContainerColor,
        errorContainerColor = errorContainerColor,

        focusedIndicatorColor = focusedIndicatorColor,
        unfocusedIndicatorColor = unfocusedIndicatorColor,
        disabledIndicatorColor = disabledIndicatorColor,
        errorIndicatorColor = errorIndicatorColor,

        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unfocusedLabelColor,
        disabledLabelColor = disabledLabelColor,
        errorLabelColor = errorLabelColor,

        focusedPlaceholderColor = focusedPlaceholderColor,
        unfocusedPlaceholderColor = unfocusedPlaceholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        errorPlaceholderColor = errorPlaceholderColor,

        focusedSupportingTextColor = focusedSupportingTextColor,
        unfocusedSupportingTextColor = unfocusedSupportingTextColor,
        disabledSupportingTextColor = disabledSupportingTextColor,
        errorSupportingTextColor = errorSupportingTextColor,

        focusedPrefixColor = focusedPrefixColor,
        unfocusedPrefixColor = unfocusedPrefixColor,
        disabledPrefixColor = disabledPrefixColor,
        errorPrefixColor = errorPrefixColor,
        focusedSuffixColor = focusedSuffixColor,
        unfocusedSuffixColor = unfocusedSuffixColor,
        disabledSuffixColor = disabledSuffixColor,
        errorSuffixColor = errorSuffixColor,

        focusedLeadingIconColor = focusedLeadingIconColor,
        unfocusedLeadingIconColor = unfocusedLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        focusedTrailingIconColor = focusedTrailingIconColor,
        unfocusedTrailingIconColor = unfocusedTrailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,
    )
}
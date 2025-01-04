package ai.truelink.app.presentation.components.inputFields

import ai.truelink.app.presentation.components.buttons.CustomIconButton
import ai.truelink.app.presentation.components.buttons.CustomIconButtonSize
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.true_expensess.R
import com.example.true_expensess.presentation.components.image.DynamicImage
import com.example.true_expensess.ui.customTheme.Theme
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization


/**
 * A composable function that creates a customizable search bar with a clear text functionality.
 * This search bar supports a placeholder, a trailing element, and dynamically shows a clear button when the field is focused and not empty.
 * It is designed to handle user input for search operations, including URI inputs, and provides visual feedback on focus changes.
 *
 * @param modifier A [Modifier] applied to the search bar, allowing customization of its appearance and layout.
 * @param placeholder An optional [String] that displays a hint to the user when the input field is empty.
 * @param trailingElement An optional trailing composable that is displayed when the input field is not focused.
 *                        This can be used to add additional actions or content to the end of the search bar.
 *
 * @author Aman Singh @amansinghtech
 */
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    onSearch: () -> Unit = {},
    trailingElement: @Composable (() -> Unit)? = null,
    clearOnFocusLost: Boolean = true,
    onValueChange: (String) -> Unit = {}
) {
    // State for storing the current input value
    var urlInput by rememberSaveable {
        mutableStateOf("")
    }

    // State to track if the text field is currently focused
    var textFieldHasFocus by rememberSaveable {
        mutableStateOf(false)
    }

    // Access to the focus manager to control focus programmatically
    val focusManager = LocalFocusManager.current

    // Effect to clear focus when the input is empty
    LaunchedEffect(key1 = urlInput) {
        if (urlInput.isEmpty()) focusManager.clearFocus()
    }

    // Layout for the search bar
    Row(
        modifier = modifier
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center,
        ) {
            // Input field with custom styling and behavior
            InputField(
                modifier = Modifier.onFocusChanged {
                    Log.d("Focus", "Focus changed to ${it.hasFocus}")
                    textFieldHasFocus = it.hasFocus
                },
                colors = OutlinedInputFieldDefaults.DefaultColors.copy(
                    unfocusedContainerColor = Theme.Mapped.Surface600,
                    focusedIndicatorColor = Theme.System.Secondary600,
                    focusedContainerColor = Theme.Mapped.Surface700,
                ),
                value = urlInput,
                onValueChange = {
                    urlInput = it
                    onValueChange(it)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Uri,
                    imeAction = ImeAction.Search,
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        focusManager.clearFocus()
                        onSearch()
                    },
                ),
                placeholder = placeholder,
                placeholderTextStyle = Theme.Typography.l2,
                size = InputFieldSize.MEDIUM,
                variant = InputFieldVariant.OUTLINED,
                shape = CircleShape,
                startIcon = {
                    DynamicImage(
                        imageSource = DynamicImageSource.Local(
                            R.drawable.ic_search,
                            asVector = true
                        ),
                        customization = ImageCustomization(tint = Theme.Mapped.Text.Active)
                    )
                },
                endIcon = {
                    // Clear text button shown only when the field is focused
                    if (textFieldHasFocus) {
                        CustomIconButton(
                            shape = CircleShape,
                            size = CustomIconButtonSize.SMALL,
                            onClick = {
                                focusManager.clearFocus()
                                if (clearOnFocusLost) {
                                    urlInput = ""
                                    onValueChange("")
                                }
                            },
                            icon = DynamicImageSource.Vector(
                                Icons.Default.Close
                            )
                        )
                    }
                },
            )

        }
        // Trailing element shown only when the field is not focused
        if (!textFieldHasFocus && trailingElement != null) {
            trailingElement()
        }
    }
}
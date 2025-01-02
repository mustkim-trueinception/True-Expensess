package shortener.truelink.app.presentation.components.image

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import com.example.true_expensess.R
import shortener.truelink.app.presentation.components.image.DynamicImageSource.DrawableObject
import shortener.truelink.app.presentation.components.image.DynamicImageSource.ImageUri
import shortener.truelink.app.presentation.components.image.DynamicImageSource.Local
import shortener.truelink.app.presentation.components.image.DynamicImageSource.Url
import shortener.truelink.app.presentation.components.image.DynamicImageSource.Vector

/**
 * DynamicImageSource is a sealed class that defines the source of the image.
 *
 * @property Url The image will be loaded from a URL.
 * @property Local The image will be loaded from a local asset.
 * @property Vector The image will be loaded from a vector graphic.
 * @property ImageUri The image will be loaded from a URI.
 * @property DrawableObject The image will be loaded from a drawable object.
 *
 * @see [DynamicImage]
 */
sealed class DynamicImageSource {
    data class Url(
        val url: String?,
        val placeholder: Int = R.drawable.ic_fallback_image,
        val fallback: Int = R.drawable.ic_fallback_image,
        val asVector: Boolean = false
    ) : DynamicImageSource()

    data class Local(val localImage: Int, val asVector: Boolean = false) : DynamicImageSource()
    data class Vector(val vectorImage: ImageVector) : DynamicImageSource()
    data class ImageUri(val uri: Uri) : DynamicImageSource()
    data class DrawableObject(val drawable: Drawable) : DynamicImageSource()
}


/**
 * ImageCustomization is a data class that allows you to modify the appearance of the image.
 *
 * @param contentScale Defines how the content should be scaled. Default is 'ContentScale.Crop'.
 * @param alignment Alignment within the box. Default is 'Alignment.Center'.
 * @param colorFilter An optional color filter to be applied to the image.
 * @param tint An optional tint color to be applied to the image vector.
 *
 */
data class ImageCustomization(
    val modifier: Modifier = Modifier,
    val contentScale: ContentScale = ContentScale.FillWidth,
    val alignment: Alignment = Alignment.Center,
    val colorFilter: ColorFilter? = null,
    val tint: Color? = null,
) {
    companion object {
        val Default
            @Composable
            get() = ImageCustomization(
                tint = LocalContentColor.current
            )
    }
}
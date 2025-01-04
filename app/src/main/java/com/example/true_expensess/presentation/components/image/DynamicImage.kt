package com.example.true_expensess.presentation.components.image

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization


/**
 * DynamicImage provides a flexible way to display images. It can handle various image sources
 * including URLs, local assets, or even vector graphics. This component ensures a unified
 * interface for image rendering across different types of sources.
 *
 * @param imageSource The source of the image. Can be a URL, local asset, or vector graphic.
 * @param description An optional content description for the image. Essential for accessibility.
 * @param customization An optional customization object that allows you to modify the image's appearance.
 *
 * @see [DynamicImageSource]
 *
 * @author
 * Deepak Yadu @deepak404found
 */

@Composable
fun DynamicImage(
    imageSource: DynamicImageSource,
    description: String? = null,
    customization: ImageCustomization = ImageCustomization.Default
) {
    when (imageSource) {
        is DynamicImageSource.Url -> {
            // load image from url
            var imageIsLoaded by rememberSaveable {
                mutableStateOf(false)
            }

            val colorFilter by remember {
                derivedStateOf {
                    val colorFilter = customization.colorFilter
                        ?: if (customization.tint != null) ColorFilter.tint(
                            customization.tint
                        ) else null

                    if (imageSource.asVector)
                        colorFilter
                    else if (!imageIsLoaded)
                        colorFilter
                    else null
                }
            }

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageSource.url)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = description,
                contentScale = customization.contentScale,
                alignment = customization.alignment,
                colorFilter = colorFilter,
                modifier = customization.modifier,
                placeholder = painterResource(id = imageSource.placeholder),
                error = painterResource(id = imageSource.fallback),
                onError = { error ->
                    Log.e("DynamicImage", "URL: ${imageSource.url} DynamicImage Error: $error")
                },
//                    onLoading = { loading ->
//                        Log.d("DynamicImage", "DynamicImage: $loading, URL: ${imageSource.url}")
//                    },
                onSuccess = { success ->
                    Log.d("DynamicImage", "DynamicImage: $success")
                    imageIsLoaded = true
                }
            )
        }

        is DynamicImageSource.Local -> {
            // load image from local
            if (imageSource.asVector) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = imageSource.localImage),
                    contentDescription = null,
                    modifier = customization.modifier,
                    tint = customization.tint ?: LocalContentColor.current,
                )
            } else {
                Image(
                    painter = painterResource(id = imageSource.localImage),
                    contentDescription = description,
                    contentScale = customization.contentScale,
                    alignment = customization.alignment,
                    colorFilter = customization.colorFilter,
                    modifier = customization.modifier
                )
            }
        }

        is DynamicImageSource.Vector -> {
            Icon(
                imageVector = imageSource.vectorImage,
                contentDescription = null,
                modifier = customization.modifier,
                tint = customization.tint ?: LocalContentColor.current,
            )
        }

        is DynamicImageSource.ImageUri -> {
            // load image from uri
            Image(
                painter = rememberAsyncImagePainter(imageSource.uri),
                contentDescription = description,
                contentScale = customization.contentScale,
                alignment = customization.alignment,
                colorFilter = customization.colorFilter,
                modifier = customization.modifier
            )
        }

        is DynamicImageSource.DrawableObject ->
            Image(
                painter = rememberAsyncImagePainter(imageSource.drawable),
                contentDescription = description,
                contentScale = customization.contentScale,
                alignment = customization.alignment,
                colorFilter = customization.colorFilter,
                modifier = customization.modifier
            )
    }
}
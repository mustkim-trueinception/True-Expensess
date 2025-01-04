package ai.truelink.app.presentation.components.inputFields

import ai.truelink.app.ui.customTheme.Theme
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import shortener.truelink.app.presentation.components.image.DynamicImage
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization

@Composable
fun MultiSelectImage(label: String? = null, maxCount: Int = 4) {

    val images = remember {
        mutableStateListOf<Uri>()
    }

    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia()
        ) { uri ->
            uri ?: return@rememberLauncherForActivityResult
            if (images.size < maxCount) {
                images.add(uri)
            }
        }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (label != null) Text(
            text = label,
            style = Theme.Typography.l1,
            fontWeight = FontWeight.Medium
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(images) {
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    DynamicImage(
                        imageSource = DynamicImageSource.ImageUri(it),
                        customization = ImageCustomization(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .border(1.dp, Theme.Mapped.Shade500, RoundedCornerShape(8.dp)),
                        )
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset(4.dp, (-4).dp)
                            .background(Theme.Mapped.Error.Main, shape = CircleShape)
                            .clip(CircleShape)
                            .padding(4.dp)
                            .clickable {
                                images.remove(it)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        DynamicImage(
                            imageSource = DynamicImageSource.Vector(Icons.Default.Close),
                            customization = ImageCustomization(
                                tint = Theme.Mapped.Error.TextMain,
                                modifier = Modifier.size(16.dp)
                            )
                        )
                    }
                }
            }

            if (images.size < maxCount) {
                item {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Theme.Mapped.Shade500, RoundedCornerShape(8.dp))
                            .clickable {
                                launcher.launch(
                                    PickVisualMediaRequest(
                                        mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                    )
                                )
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        DynamicImage(
                            imageSource = DynamicImageSource.Vector(Icons.Default.Add),
                            customization = ImageCustomization(
                                tint = Theme.Mapped.Text.Inactive,
                                modifier = Modifier.size(32.dp)
                            )
                        )
                    }
                }
            }
        }
    }
}
package ai.truelink.app.ui.customTheme

import ai.truelink.app.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

interface CustomType {
    val h1: TextStyle
    val h2: TextStyle
    val h3: TextStyle
    val h4: TextStyle
    val h5: TextStyle
    val h6: TextStyle
    val p1: TextStyle
    val p2: TextStyle
    val p3: TextStyle
    val p4: TextStyle
    val l1: TextStyle
    val l2: TextStyle
    val l3: TextStyle
    val l4: TextStyle
    val overlineLarge: TextStyle
    val overlineSmall: TextStyle
}

val InterFontFamily = FontFamily(
    Font(R.font.inter_regular, weight = FontWeight.Normal),
    Font(R.font.inter_medium, weight = FontWeight.Medium),
    Font(R.font.inter_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.inter_bold, weight = FontWeight.Bold),
    Font(R.font.inter_extra_bold, weight = FontWeight.ExtraBold)
)

enum class FormFactor {
    Mobile, Tablet, Desktop
}


data class TypographySystem(
    val formFactor: FormFactor = FormFactor.Mobile,
    val color: Color = BaseColors.TextDark.Active
) :
    CustomType {
    private val baseStyle = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Normal,
        color = color
    )
    override val h1: TextStyle = when (formFactor) {
        FormFactor.Desktop -> baseStyle.copy(
            fontSize = 40.sp,
            lineHeight = 58.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = (-0.8).sp
        )

        FormFactor.Mobile, FormFactor.Tablet -> baseStyle.copy(
            fontSize = 36.sp,
            lineHeight = 44.sp,
            fontWeight = FontWeight.Medium
        )
    }
    override val h2: TextStyle = when (formFactor) {
        FormFactor.Desktop -> baseStyle.copy(
            fontSize = 36.sp,
            lineHeight = 44.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = (-0.8).sp
        )

        FormFactor.Mobile, FormFactor.Tablet -> baseStyle.copy(
            fontSize = 32.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Medium
        )
    }
    override val h3: TextStyle = when (formFactor) {
        FormFactor.Desktop -> baseStyle.copy(
            fontSize = 32.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = (-0.8).sp
        )

        FormFactor.Mobile, FormFactor.Tablet -> baseStyle.copy(
            fontSize = 28.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight.Medium
        )
    }
    override val h4: TextStyle = when (formFactor) {
        FormFactor.Desktop -> baseStyle.copy(
            fontSize = 28.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = (-0.8).sp
        )

        FormFactor.Mobile, FormFactor.Tablet -> baseStyle.copy(
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Medium
        )
    }
    override val h5: TextStyle = when (formFactor) {
        FormFactor.Desktop -> baseStyle.copy(
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = (-0.8).sp
        )

        FormFactor.Mobile, FormFactor.Tablet -> baseStyle.copy(
            fontSize = 20.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Medium
        )
    }
    override val h6: TextStyle = when (formFactor) {
        FormFactor.Desktop -> baseStyle.copy(
            fontSize = 20.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = (-0.8).sp
        )

        FormFactor.Mobile, FormFactor.Tablet -> baseStyle.copy(
            fontSize = 18.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Medium
        )
    }
    override val p1: TextStyle = baseStyle.copy(
        fontSize = 18.sp,
        lineHeight = 28.sp
    )
    override val p2: TextStyle = baseStyle.copy(
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
    override val p3: TextStyle = baseStyle.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
    override val p4: TextStyle = baseStyle.copy(
        fontSize = 12.sp,
        lineHeight = 20.sp
    )
    override val l1: TextStyle = baseStyle.copy(
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
    override val l2: TextStyle = baseStyle.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
    override val l3: TextStyle = baseStyle.copy(
        fontSize = 12.sp,
        lineHeight = 16.sp
    )
    override val l4: TextStyle = baseStyle.copy(
        fontSize = 10.sp,
        lineHeight = 14.sp
    )
    override val overlineLarge: TextStyle = baseStyle.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.Medium,
    )
    override val overlineSmall: TextStyle = baseStyle.copy(
        fontSize = 12.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.Medium,
    )
}
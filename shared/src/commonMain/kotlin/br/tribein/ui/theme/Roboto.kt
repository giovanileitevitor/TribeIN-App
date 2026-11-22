package br.tribein.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import tribein.shared.generated.resources.Res
import tribein.shared.generated.resources.roboto_variable

@Composable
fun rememberRobotoFontFamily(): FontFamily {
    val roboto = Font(Res.font.roboto_variable)
    return remember(roboto) { FontFamily(roboto) }
}

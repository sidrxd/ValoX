package ui.theme

import androidx.compose.ui.graphics.Color
import utils.Utils


val ShimmerColorShades = listOf(
    Color.LightGray.copy(0.5f),
    Color.LightGray.copy(0.2f),
    Color.LightGray.copy(0.5f)
)
object Color {
    val secondaryText = Utils.hexToColor("8f9194")
    val primaryText = Utils.hexToColor("f9f9f9")
    val titleText = Utils.hexToColor("ff4654")
    val colorBackground = Utils.hexToColor("1c212e")
    val colorSurface = Utils.hexToColor("272b3d")
}
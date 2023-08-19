package utils

import androidx.compose.ui.graphics.Color

object Utils {
    fun hexToColor(hex: String): Color {
        val hexc = "#$hex"
        val colorInt = hexc.substring(1).toLong(16)
        val red = (colorInt shr 16 and 0xFF).toFloat() / 255.0f
        val green = (colorInt shr 8 and 0xFF).toFloat() / 255.0f
        val blue = (colorInt and 0xFF).toFloat() / 255.0f
        return Color(red, green, blue, 1.0f)
    }
}
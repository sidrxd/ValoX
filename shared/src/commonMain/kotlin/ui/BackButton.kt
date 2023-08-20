package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.Utils

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BackButton(
    onClick: () -> Boolean?
) {
    Image(
        painter = painterResource("back.xml"),
        null,
        colorFilter = ColorFilter.tint(
            Utils.hexToColor(
                "ffffff"
            )
        ),
        modifier = Modifier.padding(
            16.dp,
            48.dp
        )/*.background(color = ui.Color.colorBackground, shape = RoundedCornerShape(56.dp))*/
            .width(36.dp).height(36.dp).padding(4.dp)
            .clickable {
               onClick()
            }
    )
}
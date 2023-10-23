package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.Color
import ui.theme.Dimens

@Composable
fun ContentLoader() {
    Box(contentAlignment = androidx.compose.ui.Alignment.Center) {
        CircularProgressIndicator(
            color = Color.titleText,
            modifier = Modifier.padding(8.dp).height(Dimens.DP_36)
                .width(Dimens.DP_36).fillMaxWidth().fillMaxHeight()
        )
    }
}

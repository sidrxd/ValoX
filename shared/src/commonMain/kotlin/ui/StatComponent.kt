package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.theme.Color
import ui.theme.Dimens

@Composable
fun StatComponent(
    modifier: Modifier = Modifier,
    title: String = "",
    statValue: String = "",
    progressValue: Float = 0.0f
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth().padding(Dimens.DP_16)
    ) {
        Text(text = title, color = Color.primaryText)
        Text(text = statValue, color = Color.primaryText)
    }
}

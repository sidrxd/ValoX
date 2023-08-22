package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import ui.theme.Dimens
import ui.theme.Shapes

@Composable
fun ShimmerItem(
    brush: Brush,
    shimmerHeight: Dp
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ui.theme.Color.colorBackground)
    ) {
        Spacer(
            modifier = Modifier
                .absolutePadding(
                    Dimens.DP_16,
                    Dimens.DP_16,
                    Dimens.DP_16,
                    Dimens.DP_0
                )
                .height(shimmerHeight)
                .fillMaxWidth()
                .background(
                    brush = brush,
                    shape = Shapes.medium
                )
                .padding(Dimens.DP_4)

        )

    }
}

package ui

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import ui.theme.ShimmerColorShades

@Composable
fun ShimmerAnimation(
	shimmerHeight :Dp
) {
	val transition = rememberInfiniteTransition()
	val translateAnim by transition.animateFloat(
		initialValue = 0f,
		targetValue = 1000f,
		animationSpec = infiniteRepeatable(
			tween(durationMillis = 1200, easing = FastOutSlowInEasing),
			RepeatMode.Reverse
		)
	)
	val brush = Brush.linearGradient(
		colors = ShimmerColorShades,
		start = Offset(10f, 10f),
		end = Offset(translateAnim, translateAnim)
	)

	ShimmerItem(brush = brush, shimmerHeight = shimmerHeight)
}

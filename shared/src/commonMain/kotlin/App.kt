import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import connection.ApiHelper
import connection.ValorantApiResponse
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ui.AbilitiesScreen
import ui.Color
import ui.MainScreen
import utils.Utils.hexToColor

@Composable
fun App() {

    val agents = MutableStateFlow(ArrayList<ValorantApiResponse.Data?>())
    MaterialTheme {
        CoroutineScope(Dispatchers.IO).launch {
            agents.emit(ApiHelper().getEntries()!!)
        }

        if (agents.collectAsState().value.size == 0) {
            Box(
                modifier = Modifier.fillMaxSize().background(ui.Color.colorBackground),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            MainScreen(agents.collectAsState().value)
            //AgentsScreen(agents.collectAsState().value)
        }


    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AgentsScreen(value: ArrayList<ValorantApiResponse.Data?>, i: Int) {
    val pagerState = rememberPagerState(0)

    Column {

        VerticalPager(value.size, state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
            val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

            val layoutSize by animateFloatAsState(
                targetValue = if (pageOffset != 0.0f) 0.95f else 1f,
                animationSpec = tween(durationMillis = 200)
            )
            val agent = value[page]
            val name = agent?.displayName
            val info = agent?.description
            val role = agent?.role?.displayName
            val dp = agent?.fullPortrait
            val background = agent?.background
            val gradient = Brush.linearGradient(
                listOf(
                    hexToColor("1C252E"), hexToColor("1C252E")
                )
            )
            Column(
                modifier = Modifier.fillMaxSize().background(
                    gradient
                ).padding(0.dp, 24.dp, 0.dp, 0.dp).graphicsLayer {
                    scaleX = layoutSize
                    scaleY = layoutSize
                }
            ) {
                Box(
                    modifier = Modifier.height(440.dp)

                ) {
                    background?.let { asyncPainterResource(it) }?.let {
                        KamelImage(
                            it,
                            contentDescription = null,
                            modifier = Modifier.alpha(0.05f).fillMaxWidth().scale(2.5f)
                        )
                    }

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = name.toString().toUpperCase(Locale.current),
                            fontSize = 56.sp,
                            fontWeight = FontWeight(800),
                            color = hexToColor("FF4654")
                        )
                        Text(
                            text = role.toString(),
                            fontSize = 16.sp,
                            color = Color.secondaryText

                        )
                    }

                    dp?.let { asyncPainterResource(it) }
                        ?.let {
                            KamelImage(
                                it,
                                contentDescription = null,
                                modifier = Modifier.scale(1.3f).clickable {

                                })
                        }

                }

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {

                    Text(
                        text = "BIOGRAPHY",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.primaryText
                    )
                    Text(
                        text = info.toString(),
                        fontSize = 14.sp,
                        color = Color.secondaryText

                    )

                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "ABILITIES",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.primaryText

                    )

                    AbilitiesScreen(agent)


                }
            }


        }

    }

}


expect fun getPlatformName(): String
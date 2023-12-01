package screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import model.ValorantApiResponse
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.flow.MutableStateFlow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.Color
import ui.MenuScreenLayout
import utils.Coroutines
import utils.Utils

@OptIn(ExperimentalResourceApi::class)

class MainScreen(private val agentList: ArrayList<ValorantApiResponse.Data>) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val isAgentVisible = remember { MutableStateFlow(false) }
        val openAgentList = remember { MutableStateFlow(0) }

        Column(
            modifier = Modifier.fillMaxSize().background(Color.colorBackground).padding(16.dp)
        ) {
            Spacer(modifier = Modifier.padding(0.dp, 16.dp))

            Text(
                text = "ValoX", fontSize = 48.sp,
                fontWeight = FontWeight(800),
                color = Utils.hexToColor("FF4654")
            )
            MenuScreenLayout()

            Spacer(modifier = Modifier.padding(0.dp, 8.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(0.dp)
            ) {
                items(agentList.size) { position ->
                    Box(
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Image(
                            painter = painterResource("rectangle_1.xml"),
                            null,
                            colorFilter = ColorFilter.tint(
                                Utils.hexToColor(
                                    "272b3d"
                                )
                            ),
                            modifier = Modifier.clickable {
                                Coroutines.main {
                                    isAgentVisible.emit(true)
                                    openAgentList.emit(position)
                                }
                            }
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            AnimatedVisibility(true) {
                                KamelImage(
                                    asyncPainterResource(agentList[position]?.fullPortrait.toString()),
                                    contentDescription = null,
                                    modifier = Modifier.scale(1.5f).height(220.dp)
                                )
                            }

                            agentList[position]?.displayName?.let { it1 ->
                                Text(
                                    text = it1,
                                    fontSize = 18.sp,
                                    color = Color.primaryText,
                                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                                )
                            }
                        }
                    }
                }
            }
            if (isAgentVisible.collectAsState().value) {
                navigator?.push(AgentsScreen(agentList, openAgentList.collectAsState().value))
                println(openAgentList.collectAsState().value)
            }


        }


    }

}

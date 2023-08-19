package ui

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import connection.ValorantApiResponse
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.Utils

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreen(agentList: ArrayList<ValorantApiResponse.Data?>) {

    Column(modifier = Modifier.fillMaxSize().background(Color.colorBackground).padding(16.dp)) {
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        Text(
            text = "Valogent", fontSize = 48.sp,
            fontWeight = FontWeight(800),
            color = Utils.hexToColor("FF4654")
        )
        Spacer(modifier = Modifier.padding(0.dp, 8.dp))

        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(0.dp)) {
            items(agentList.size) {
                Box(modifier = Modifier.fillMaxSize().padding(8.dp).clickable {
                    /*
                             AgentsScreen(value = agentList,it)*/
                }, contentAlignment = Alignment.BottomCenter) {
                    Image(
                        painter = painterResource("rectangle_1.xml"),
                        null,
                        colorFilter = ColorFilter.tint(
                            Utils.hexToColor(
                                "272b3d"
                            )
                        )
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        AnimatedVisibility(true) {
                            KamelImage(
                                asyncPainterResource(agentList[it]?.fullPortrait.toString()),
                                contentDescription = null,
                                modifier = Modifier.scale(1.5f).height(220.dp)
                            )
                        }

                        agentList[it]?.displayName?.let { it1 ->
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
    }


}
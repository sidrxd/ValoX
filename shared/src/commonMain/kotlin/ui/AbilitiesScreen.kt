package ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import connection.ValorantApiResponse
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AbilitiesScreen(agent: ValorantApiResponse.Data?) {
    val abilityPagerState = rememberPagerState(0)
    val pageCount = agent!!.abilities!!.size

    Row(
        Modifier
            .height(24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        repeat(pageCount) { iteration ->

            val color = if (abilityPagerState.currentPage == iteration) Color.titleText else Color.secondaryText

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(8.dp)
            )
        }
    }

    HorizontalPager(pageCount, state = abilityPagerState) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row {
                agent.abilities?.get(it)!!.displayIcon?.let { it1 ->
                    asyncPainterResource(
                        it1
                    )
                }?.let { it2 ->
                    KamelImage(
                        it2,
                        contentDescription = "",
                        modifier = Modifier.width(48.dp).height(48.dp)
                    )
                }

            }
            Spacer(modifier = Modifier.padding(8.dp))
            agent.abilities?.get(it)?.displayName?.let { it1 ->
                Text(
                    text = it1,
                    fontSize = 18.sp,
                    color = Color.primaryText

                )
            }
            agent.abilities?.get(it)?.description?.let { it1 ->
                Text(
                    text = it1,
                    fontSize = 14.sp,
                    color = Color.secondaryText

                )
            }
        }
    }
}
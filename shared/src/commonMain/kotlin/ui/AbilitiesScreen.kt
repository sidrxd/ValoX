package ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import connection.ValorantApiResponse
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AbilitiesScreen(agent: ValorantApiResponse.Data?) {
    val abilityPagerState = rememberPagerState(0)
    HorizontalPager(agent!!.abilities!!.size, state = abilityPagerState) {
        Column (modifier = Modifier.fillMaxSize()){
            Spacer(modifier = Modifier.padding(8.dp))
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
package screen.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.flow.MutableStateFlow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.BackButton
import ui.Color
import utils.Coroutines
import utils.Utils


class CardScreen : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current

        val gridCells = remember { MutableStateFlow(2) }

        Box(modifier = Modifier.fillMaxSize().background(color = Color.colorBackground)) {
            val cardsScreenModel = rememberScreenModel { CardsScreenModel() }
            cardsScreenModel.getCards()
            val state = cardsScreenModel.cards.collectAsState()
            val upGrid = gridCells.collectAsState().value
            val list = state.value
            if (list.size > 0) {
                LazyVerticalGrid(columns = GridCells.Fixed(upGrid), modifier = Modifier.fillMaxSize()) {
                    items(list.size) {
                        val card = list[it]

                        if (upGrid==1){
                            KamelImage(
                                asyncPainterResource(card.largeArt.toString()),
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth().fillMaxSize().background(color = Color.colorSurface),
                                contentScale = ContentScale.FillWidth
                            )
                        }else{
                            KamelImage(
                                asyncPainterResource(card.largeArt.toString()),
                                contentDescription = null,
                                modifier = Modifier.height(480.dp).background(color = Color.colorSurface)
                            )
                        }

                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                BackButton{
                    navigator?.pop()
                }

                Image(
                    painter = painterResource("grid.xml"),
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
                            if (upGrid==1){
                                Coroutines.io {
                                    gridCells.emit(2)
                                }
                            }else{
                                Coroutines.io {
                                    gridCells.emit(1)
                                }
                            }

                        }
                )
            }



        }
    }
}
package screen.weapons.skins

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.WeaponsResponse
import ui.BackButton
import ui.ContentLoader
import ui.theme.Color
import ui.theme.Dimens

class SkinScreen(private val skins: List<WeaponsResponse.Data.Skin?>) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Box(modifier = Modifier.fillMaxSize().background(color = Color.colorBackground)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(8.dp, 78.dp, 8.dp, 0.dp)
            ) {
                items(skins.size) {
                    var skinImageUrl = skins[it]?.displayIcon
                    val skinName = skins[it]?.displayName.toString()
                    if (skinImageUrl==null){
                        skinImageUrl = skins[it]?.chromas?.get(0)?.displayIcon
                    }
                    println("skinImageUrl: $skinImageUrl")
                    if (!skinName.contains("Standard") && skinImageUrl != null) {
                        Column(
                            modifier = Modifier.padding(8.dp).background(
                                color = Color.colorSurface,
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
                            ).padding(8.dp)
                        ) {
                            KamelImage(
                                resource = asyncPainterResource(skinImageUrl.toString()),
                                modifier = Modifier.padding(8.dp),
                                contentDescription = null,
                                onLoading = {
                                    // Display a circular progress indicator whilst loading
                                    ContentLoader()
                                },
                            )
                            Text(
                                text = skinName,
                                modifier = Modifier.padding(8.dp),
                                color = Color.secondaryText,
                                maxLines = 1
                            )
                        }

                    }

                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }
            BackButton {
                navigator?.pop()
            }
        }

    }
}
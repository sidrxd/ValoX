package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import screen.ComingSoonScreen
import screen.cards.CardScreen
import screen.weapons.WeaponScreen
import utils.Utils


@OptIn(ExperimentalResourceApi::class)
@Composable
fun MenuScreenLayout() {
    val navigator = LocalNavigator.current
    val list = ArrayList<MenuModel>()
    list.add(MenuModel("Buddies"))
    list.add(MenuModel("Weapons"))
    list.add(MenuModel("Bundles"))
    list.add(MenuModel("Cards"))

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(list.size) {
            Box(
                modifier = Modifier.padding(8.dp, 8.dp).height(76.dp).background(
                    color = Color.colorSurface, shape = RoundedCornerShape(16.dp)
                ).clickable {
                    when(list[it].title){
                        "Cards" ->{
                            navigator?.push(CardScreen())

                        }

                        "Weapons" ->{
                            navigator?.push(WeaponScreen())

                        }
                        else ->{
                            navigator?.push(ComingSoonScreen())

                        }
                    }
                },
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = list[it].title,
                    modifier = Modifier.padding(8.dp, 0.dp),
                    color = Color.primaryText
                )
            }
        }

    }

}

data class MenuModel(
    val title: String,
    val icon: String? = null
)

enum class MENU_CAT {
    WEAPONS,
    BUDDIES,
    BUNDLES,
    CARDS
}
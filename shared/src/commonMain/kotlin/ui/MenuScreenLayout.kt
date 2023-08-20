package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
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
    //list.add(MenuModel("Buddies"))
    list.add(MenuModel("Weapons", color = "FF5733"))
/*
    list.add(MenuModel("Bundles"))
*/
    list.add(MenuModel("Cards", color = "C70039"))
/*
    Column {
        Spacer(modifier = Modifier.padding(0.dp,16.dp))
        TextField(value = "Search...", onValueChange = {

        }, modifier = Modifier.fillMaxWidth().background(color = Color.colorSurface, RoundedCornerShape(16.dp)))
        Spacer(modifier = Modifier.padding(0.dp,8.dp))

    }*/
    Spacer(modifier = Modifier.padding(0.dp,8.dp))

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(list.size) {
            Box(
                modifier = Modifier.padding(8.dp, 8.dp).height(76.dp).background(
                    color = Utils.hexToColor(list[it].color.toString()), shape = RoundedCornerShape(20.dp)
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
                contentAlignment = Alignment.BottomStart
            ) {

                Text(
                    text = list[it].title,
                    modifier = Modifier.padding(16.dp, 16.dp),
                    color = Color.primaryText,
                    fontWeight = FontWeight(600)
                )
            }
        }

    }

}

data class MenuModel(
    val title: String,
    val icon: String? = null,
    val color : String? = null
)

enum class MENU_CAT {
    WEAPONS,
    BUDDIES,
    BUNDLES,
    CARDS
}
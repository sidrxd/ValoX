package screen.weapons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.flow.MutableStateFlow
import model.WeaponsResponse
import ui.BackButton
import ui.ShimmerAnimation
import ui.theme.Color
import ui.theme.Dimens

class WeaponScreen : Screen {
    @Composable
    override fun Content() {
        val weaponsScreenModel = rememberScreenModel { WeaponsScreenModel() }
        val navigator = LocalNavigator.current
        val gridCells = remember { MutableStateFlow(2) }

        Box(modifier = Modifier.fillMaxSize().background(color = Color.colorBackground)) {
            weaponsScreenModel.getWeapons()
            val weapons = weaponsScreenModel.weapons.collectAsState().value
            if (weapons.size ==0){
                LazyColumn(modifier = Modifier.padding(0.dp, 72.dp, 0.dp, 0.dp)){
                    items(10){
                        ShimmerAnimation(Dimens.DP_120)
                    }
                }
            }else {
                showWeapons(weapons, navigator)
            }
            BackButton {
                navigator?.pop()
            }
        }
    }
}

@Composable
fun showWeapons(
    weapons: ArrayList<WeaponsResponse.Data>,
    navigator: Navigator?
) {
    LazyColumn(modifier = Modifier.padding(0.dp, 72.dp, 0.dp, 0.dp)) {
        items(weapons.size) {
            val weapon = weapons[it]
            Box(
                modifier = Modifier.padding(16.dp).background(
                    Color.colorSurface,
                    RoundedCornerShape(16.dp)
                ).height(120.dp).fillMaxWidth().clickable {
                    navigator?.push(WeaponDetailsScreen(weapon))
                }, contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = weapon.displayName.toString().toUpperCase(Locale.current),
                    fontSize = 38.sp,
                    color = Color.titleText,
                    fontWeight = FontWeight(800),
                    modifier = Modifier.padding(16.dp),
                )
                KamelImage(
                    asyncPainterResource(weapon.displayIcon.toString()),
                    null,
                    modifier = Modifier.padding(16.dp)
                )

            }
        }
    }
}
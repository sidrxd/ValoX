package screen.weapons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.WeaponsResponse
import ui.BackButton
import ui.StatComponent
import ui.theme.Color
import ui.theme.Dimens

class WeaponDetailsScreen(private val weapon: WeaponsResponse.Data) : Screen {

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Box(modifier = Modifier.fillMaxSize().background(color = Color.colorBackground)) {

            Column {


                Box(
                    modifier = Modifier.padding(0.dp, 72.dp, 0.dp, 0.dp).padding(16.dp).background(
                        Color.colorSurface,
                        RoundedCornerShape(16.dp)
                    ).height(220.dp).fillMaxWidth(), contentAlignment = Alignment.BottomStart
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

                val state = rememberPagerState(0)
                val pageCount = weapon.skins!!.size

                Column(modifier = Modifier.heightIn(Dimens.DP_220).padding(16.dp).fillMaxWidth()) {
                    Spacer(modifier = Modifier.padding(8.dp))

                    Text(
                        text = "SKINS",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.primaryText

                    )
                    Spacer(modifier = Modifier.padding(Dimens.DP_16))
                    Text(
                        text = "STATS",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.primaryText

                    )
                    Stats(weapon.weaponStats)
                    Text(
                        text = "SKINS",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.primaryText

                    )
                    HorizontalPager(pageCount, state = state) {

                        Spacer(modifier = Modifier.padding(8.dp))

                        KamelImage(
                            asyncPainterResource(weapon.skins[it]?.displayIcon.toString()),
                            null,
                            modifier = Modifier.padding(16.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                }


            }
            BackButton {
                navigator?.pop()
            }
        }
    }
}

@Composable
fun Stats(stats: WeaponsResponse.Data.WeaponStats?) {
    Column (modifier = Modifier.background(Color.colorSurface, shape = RoundedCornerShape(Dimens.DP_16))){
        stats?.run {
            StatComponent(title = "Magazine size", statValue = magazineSize.toString())
            StatComponent(title = "Fire rate", statValue = fireRate.toString())
            StatComponent(title = "Run speed", statValue = runSpeedMultiplier.toString())
            StatComponent(title = "First bullet accuracy", statValue = firstBulletAccuracy.toString())
            StatComponent(title = "Wall penetration", statValue = wallPenetration.toString())

        }
    }

}
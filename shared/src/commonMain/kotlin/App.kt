import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import connection.ApiHelper
import connection.ApiResult
import connection.MainRepository
import connection.ValorantApiResponse
import kotlinx.coroutines.flow.MutableStateFlow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screen.MainScreen
import ui.theme.Color
import ui.theme.Dimens
import utils.Coroutines

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    val agents = MutableStateFlow(ArrayList<ValorantApiResponse.Data>())
    Coroutines.io {
        when (val result = MainRepository(ApiHelper.client).getEntries()) {
            is ApiResult.APIError -> {

            }

            is ApiResult.Error -> {

            }

            is ApiResult.Success -> {
                agents.emit(result.data.data)
            }
        }
    }

    MaterialTheme {
        if (agents.collectAsState().value.size == 0) {
            Box(
                modifier = Modifier.fillMaxSize().background(Color.colorBackground),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource("logo.png"),
                        null,
                        modifier = Modifier.padding(
                            16.dp,
                            16.dp
                        ).height(Dimens.DP_120).width(Dimens.DP_120).clip(
                            RoundedCornerShape(Dimens.DP_16)
                        )
                    )
                    LinearProgressIndicator(
                        color = Color.titleText,
                        modifier = Modifier.width(Dimens.DP_120).clip(RoundedCornerShape(Dimens.DP_16))
                    )
                }
            }
        } else {
            Navigator(MainScreen(agents.collectAsState().value))
        }


    }

}


expect fun getPlatformName(): String
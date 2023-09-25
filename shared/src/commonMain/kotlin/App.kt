import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import connection.ApiHelper
import connection.ApiResult
import connection.MainRepository
import connection.ValorantApiResponse
import kotlinx.coroutines.flow.MutableStateFlow
import screen.MainScreen
import ui.theme.Color
import utils.Coroutines
import utils.Utils

@Composable
fun App() {
    val agents = MutableStateFlow(ArrayList<ValorantApiResponse.Data>())
    Coroutines.io {
        val result = MainRepository(ApiHelper.client).getEntries()
        when (result) {
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
                Column {
                    Text(
                        text = "ValoX",
                        fontSize = 48.sp,
                        fontWeight = FontWeight(800),
                        color = Utils.hexToColor("FF4654")
                    )
                    LinearProgressIndicator(color = Color.titleText)

                }
            }
        } else {
            Navigator(MainScreen(agents.collectAsState().value))
        }


    }

}


expect fun getPlatformName(): String
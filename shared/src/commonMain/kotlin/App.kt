import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import connection.ApiHelper
import connection.ApiResult
import connection.MainRepository
import connection.ValorantApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ui.MainScreen

@Composable
fun App() {
    val agents = MutableStateFlow(ArrayList<ValorantApiResponse.Data>())
    MaterialTheme {
        CoroutineScope(Dispatchers.IO).launch {
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

        if (agents.collectAsState().value.size == 0) {
            Box(
                modifier = Modifier.fillMaxSize().background(ui.Color.colorBackground),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            MainScreen(agents.collectAsState().value)
            //AgentsScreen(agents.collectAsState().value)
        }


    }

}


expect fun getPlatformName(): String
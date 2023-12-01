package connection

import connection.Url.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.path
import model.CardsResponse
import model.ValorantApiResponse
import model.WeaponsResponse

object Url{
    const val BASE_URL = "https://valorant-api.com/v1/"
}
class MainRepository(client: HttpClient) : SafeNetworkCall() {

    private val service = client
    suspend fun getEntries(): NetworkResult<ValorantApiResponse> {
        return safeApiCall({
            service.get("${BASE_URL}agents") {
                url {
                    parameters.append("isPlayableCharacter", "true")
                }
            }
        }, "agent api error")

    }

    suspend fun getCards(): NetworkResult<CardsResponse> {
        return safeApiCall({
            service.get("${BASE_URL}playercards")
        }, "weapons api error")

    }

    suspend fun getWeapons(): NetworkResult<WeaponsResponse> {
        return safeApiCall({
            service.get("${BASE_URL}weapons")
        }, "weapons api error")

    }
}
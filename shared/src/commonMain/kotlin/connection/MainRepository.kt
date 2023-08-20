package connection

import connection.Url.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import model.CardsResponse

object Url{
    const val BASE_URL = "https://valorant-api.com/v1/"
}
class MainRepository(client: HttpClient) : SafeApiCall() {

    private val service = client
    suspend fun getEntries(): ApiResult<ValorantApiResponse> {
        return safeApiCall({
            service.get("${BASE_URL}agents") {
                url {
                    parameters.append("isPlayableCharacter", "true")
                }
            }
        }, "agent api error")

    }

    suspend fun getCards(): ApiResult<CardsResponse> {
        return safeApiCall({
            service.get("${BASE_URL}playercards")
        }, "agent api error")

    }
}
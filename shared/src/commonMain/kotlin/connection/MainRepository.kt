package connection

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class MainRepository(client: HttpClient) : SafeApiCall() {

    private val service = client
    suspend fun getEntries(): ApiResult<ValorantApiResponse> {
        return safeApiCall({
            service.get("https://valorant-api.com/v1/agents") {
                url {
                    parameters.append("isPlayableCharacter", "true")
                }
            }
        }, "agent api error")

    }
}
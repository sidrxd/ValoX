package connection

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class ApiHelper {

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun getEntries(): ArrayList<ValorantApiResponse.Data?>? {
        val response = client.get("https://valorant-api.com/v1/agents"){
            url{
                parameters.append("isPlayableCharacter","true")
            }
        }
        val obj = Json.decodeFromString<ValorantApiResponse>(response.bodyAsText())
        val list = ArrayList<String>()
        obj.data?.forEach {
            list.add(it!!.displayName!!)
        }
        return obj.data
    }

}
package connection

import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.json.JsonObject

interface APIServices {

    suspend fun getAgents(

    ): HttpResponse

}
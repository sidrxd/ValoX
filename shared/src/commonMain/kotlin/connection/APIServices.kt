package connection

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse

interface APIServices {

    suspend fun getAgents(

    ): HttpClient

}
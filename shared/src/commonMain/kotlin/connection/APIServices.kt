package connection

import io.ktor.client.statement.HttpResponse

interface APIServices {

    suspend fun getAgents(

    ): HttpResponse

}
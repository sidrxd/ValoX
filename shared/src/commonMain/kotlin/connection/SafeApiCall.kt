package connection


import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

open class SafeApiCall {

    suspend inline fun <reified T : Any> safeApiCall(
        call: () -> HttpResponse,
        errorMessage: String
    ): ApiResult<T> {

        return try {
            val response = call.invoke()
            if (response.status.value == 200) {
                val obj = Json.decodeFromString<T>(response.bodyAsText())
                ApiResult.Success(obj)
            } else {
                val error = response.status
                ApiResult.APIError(
                    error.toString()
                    /* errorResponse(
                         JsonObject(
                             response.errorBody()?.string() ?: ""
                         )
                     )*/
                )
            }

        } catch (e: Exception) {
            e.printStackTrace()
            ApiResult.Error(Exception("$errorMessage: ${e.message}"))
        }
    }

    /* private fun errorResponse(obj: JSONObject): String {
         return obj.optString("message")
     }*/

}
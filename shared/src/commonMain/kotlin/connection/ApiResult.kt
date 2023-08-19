package connection

sealed class ApiResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class APIError(val string: String) : ApiResult<Nothing>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
}
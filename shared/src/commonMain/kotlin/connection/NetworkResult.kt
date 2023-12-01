package connection

sealed class NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>()
    data class NetworkError(val string: String) : NetworkResult<Nothing>()
    data class Loading(val nothing: Nothing? = null) : NetworkResult<Nothing>()
}
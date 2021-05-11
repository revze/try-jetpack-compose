package id.revan.tryjetpackcompose.core

sealed class State<T> {
    data class Success<T>(val data: T) : State<T>()
    data class Error<T>(val errorCode: Int, val message: String) : State<T>() {
        companion object {
            const val NETWORK = 1
            const val UNKNOWN = 2
        }
    }
}

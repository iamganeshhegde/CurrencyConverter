package com.example.currencyconverter

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.Success, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.Error, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.Loading, data, null)
        }

    }

}


//not used
sealed class Res<out T>(val status: Status, open val data: T?, val message: String?) {
    data class Success1<out T>(override val data: T?) : Res<T>(Status.Success, data, null)
    data class Error1<out T>(override val data: T?, val mes: String?) :
        Res<T>(Status.Success, data, mes)

    data class Load1<out T>(override val data: T?) : Res<T>(Status.Success, data, null)
}
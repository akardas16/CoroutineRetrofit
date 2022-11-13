package com.akardas.coroutine.networking

import com.akardas.coroutine.retrofit.Status

data class Conclude<out T>(val status: Status, val data: T?, val exception: Exception?) {
    companion object {
        fun <T> success(data: T): Conclude<T> = Conclude(status = Status.SUCCESS, data = data, exception = null)

        fun <T> error(exception: Exception): Conclude<T> = Conclude(status = Status.ERROR, data = null, exception = exception)

        fun <T> loading(status: Status): Conclude<T> = Conclude(status = status, data = null, exception = null)
    }


}



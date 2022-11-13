package com.akardas.coroutine.networking

import androidx.lifecycle.liveData
import com.akardas.coroutine.retrofit.Status
import kotlinx.coroutines.Dispatchers

object ConcludeData {
     fun <T> getResultData(data:T) = liveData(Dispatchers.IO) {
        emit(Conclude.loading(Status.START))
        try {
            emit(Conclude.loading(Status.FINISH))
            emit(Conclude.success(data))
        }catch (e:Exception){
            emit(Conclude.loading(Status.FINISH))
            emit(Conclude.error(e))
        }
    }
}
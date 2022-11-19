package com.akardas.coroutine.viewModels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.akardas.coroutine.networking.Conclude
import com.akardas.coroutine.networking.MainRepository
import com.akardas.coroutine.networking.models.LoginDataModel
import com.akardas.coroutine.retrofit.Status
import kotlinx.coroutines.*

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

     fun getUsers() = liveData(Dispatchers.IO) {
         emit(Conclude.loading(Status.START))
         try {
             emit(Conclude.loading(Status.FINISH))
             emit(Conclude.success(mainRepository.getUsers()))
         }catch (e:Exception){
             emit(Conclude.loading(Status.FINISH))
             emit(Conclude.error(e))
         }
     }




    fun registerUser(dataModel: LoginDataModel) = liveData(Dispatchers.IO) {
        emit(Conclude.loading(Status.START))
        try {
            emit(Conclude.loading(Status.FINISH))
            emit(Conclude.success(mainRepository.registerUser(dataModel)))
        }catch (e:Exception){
            emit(Conclude.loading(Status.FINISH))
            emit(Conclude.error(e))
        }
    }

     fun getSingleUser(userID: Int) = liveData(Dispatchers.IO) {
         emit(Conclude.loading(Status.START))
         try {
             emit(Conclude.loading(Status.FINISH))
             emit(Conclude.success(mainRepository.getSingleUser(userID)))
         }catch (e:Exception){
             emit(Conclude.loading(Status.FINISH))
             emit(Conclude.error(e))
         }
     }

    fun updateUser(dataModel: LoginDataModel,userID: Int) = liveData(Dispatchers.IO) {
        emit(Conclude.loading(Status.START))
        try {
            emit(Conclude.loading(Status.FINISH))
            emit(Conclude.success(mainRepository.updateUser(dataModel, userID)))
        }catch (e:Exception){
            emit(Conclude.loading(Status.FINISH))
            emit(Conclude.error(e))
        }
    }

    fun updateUserWithPath(dataModel: LoginDataModel) = liveData(Dispatchers.IO) {
        emit(Conclude.loading(Status.START))
        try {
            emit(Conclude.loading(Status.FINISH))
            emit(Conclude.success(mainRepository.updateUserWithPatch(dataModel)))
        }catch (e:Exception){
            emit(Conclude.loading(Status.FINISH))
            emit(Conclude.error(e))
        }
    }




}
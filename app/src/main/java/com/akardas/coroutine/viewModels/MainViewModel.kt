package com.akardas.coroutine.viewModels


import androidx.lifecycle.ViewModel
import com.akardas.coroutine.networking.MainRepository
import com.akardas.coroutine.networking.models.LoginDataModel
import com.akardas.coroutine.networking.ConcludeData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers() = runBlocking {
        withContext(Dispatchers.IO){
            ConcludeData.getResultData(mainRepository.getUsers())
        }
    }

    fun registerUser(dataModel: LoginDataModel) = runBlocking {
        withContext(Dispatchers.IO){
            ConcludeData.getResultData(mainRepository.registerUser(dataModel))
        }
    }

     fun getSingleUser(userID: Int) = runBlocking {
         withContext(Dispatchers.IO) {
             ConcludeData.getResultData(mainRepository.getSingleUser(userID))
         }
     }

    fun updateUser(dataModel: LoginDataModel,userID: Int) = runBlocking {
        withContext(Dispatchers.IO){
            ConcludeData.getResultData(mainRepository.updateUser(dataModel,userID))
        }
    }

    fun updateUserWithPath(dataModel: LoginDataModel) = runBlocking {
        withContext(Dispatchers.IO){
            ConcludeData.getResultData(mainRepository.updateUserWithPatch(dataModel))
        }
    }




}
package com.akardas.coroutine.networking

import com.akardas.coroutine.networking.models.LoginDataModel


class ApiHelper(private val apiService: ApiEndpoints) {

    suspend fun getUsers() = apiService.getUsers()
    suspend fun registerUser(dataModel: LoginDataModel) = apiService.registerUser(dataModel)
    suspend fun getSingleUser(userID:Int) = apiService.getSingleUser(userID)
    suspend fun updateUser(dataModel: LoginDataModel,userID:Int) = apiService.updateUser(dataModel,userID)
    suspend fun updateUserWithPatch(dataModel: LoginDataModel) = apiService.updateUserWithPatch(dataModel)
}
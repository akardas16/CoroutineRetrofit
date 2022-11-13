package com.akardas.coroutine.networking

import com.akardas.coroutine.networking.models.LoginDataModel


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
    suspend fun getSingleUser(userID:Int) = apiHelper.getSingleUser(userID)
    suspend fun registerUser(dataModel: LoginDataModel) = apiHelper.registerUser(dataModel)
}
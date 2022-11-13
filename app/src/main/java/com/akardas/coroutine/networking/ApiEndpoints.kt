package com.akardas.coroutine.networking

import com.akardas.coroutine.networking.models.LoginDataModel
import com.akardas.coroutine.networking.models.RegisModel
import com.akardas.coroutine.networking.models.SingleUserModel
import com.akardas.coroutine.networking.models.UserModel
import retrofit2.http.*

interface ApiEndpoints {

    @GET("api/users")
    suspend fun getUsers(): UserModel

    @POST("api/users")
    suspend fun registerUser(@Body dataModel: LoginDataModel): RegisModel

    @GET("api/users/{userID}")
    suspend fun getSingleUser(@Path("userID") userID: Int): SingleUserModel

  /*  @POST("users/language")
    suspend fun changeLanguage(): Boolean

    @GET("api/users/{user_id}")
    suspend fun getUserData(@Path("user_id") userID: String?): List<UserModel>

    @POST("api/calls")
    suspend fun createCall(callID: String?): List<UserModel>*/

}
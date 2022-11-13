package com.akardas.coroutine.networking

import com.akardas.coroutine.networking.models.*
import retrofit2.http.*

interface ApiEndpoints {

    @GET("api/users")
    suspend fun getUsers(): UserModel

    @POST("api/users")
    suspend fun registerUser(@Body dataModel: LoginDataModel): RegisModel

    @GET("api/users/{userID}")
    suspend fun getSingleUser(@Path("userID") userID: Int): SingleUserModel

    @PUT("api/users/{userID}")
    suspend fun updateUser(@Body dataModel: LoginDataModel, @Path("userID") userID: Int ):UpdateUserModel

    @PATCH("api/users/2")
    suspend fun updateUserWithPatch(@Body dataModel: LoginDataModel):UpdateUserModel

   /* @DELETE("api/users/2")
    suspend fun deleteUser():DeleteResponse?*/


}
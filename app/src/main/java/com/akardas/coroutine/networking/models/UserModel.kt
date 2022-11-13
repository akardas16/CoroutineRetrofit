package com.akardas.coroutine.networking.models

 data class UserModel (
    val page: Long,
    val perPage: Long,
    val total: Long,
    val totalPages: Long,
    val data: List<User>,
    val support: Support
)

data class User (
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
)

data class Support (
    val url: String,
    val text: String
)


/*
data class UserModel(
    @SerializedName("avatar")
    val image: String,
    @SerializedName("email")
    val userEmail: String,
    @SerializedName("id")
    val userId: String,
    @SerializedName("name")
    val userName: String)

 */
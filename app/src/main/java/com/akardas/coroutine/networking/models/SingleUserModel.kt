package com.akardas.coroutine.networking.models

data class SingleUserModel (
    val data: Data,
    val support: Support
)

data class Data (
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
)




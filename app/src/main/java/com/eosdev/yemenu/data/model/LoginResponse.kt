package com.eosdev.yemenu.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val data: Data?
)

data class Data(
    @SerializedName("accessToken")
    val accessToken: AccessToken?
)

data class AccessToken(
    @SerializedName("token")
    val token: String? = null,
    @SerializedName("expiration")
    val expiration: String?  = null
)

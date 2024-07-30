package com.eosdev.yemenu.data.api

import com.google.gson.annotations.SerializedName

data class ApiResponse (
    @SerializedName("message")
    val message: String? = null,

    @SerializedName("isSuccessful")
    val isSuccessful: Boolean? = null
)
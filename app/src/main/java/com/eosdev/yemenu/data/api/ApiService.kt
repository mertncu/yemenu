package com.eosdev.yemenu.data.api

import com.eosdev.yemenu.data.model.User
import com.eosdev.yemenu.data.model.UserForLoginDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {


    @Headers("Content-Type: application/json")
    @POST("Auth/Login")
    fun login(
        @Body userForLoginDto: UserForLoginDto
    ): Call<User>
}

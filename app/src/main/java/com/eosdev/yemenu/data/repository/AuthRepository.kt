package com.eosdev.yemenu.data.repository

import android.util.Log
import com.eosdev.yemenu.data.api.auth.AuthApiService
import com.eosdev.yemenu.data.model.LoginResponse
import com.eosdev.yemenu.data.model.User
import com.eosdev.yemenu.utils.TokenManager
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: AuthApiService,
    private val tokenManager: TokenManager
) {
    private val tag = "AuthRepository"

    suspend fun login(email: String, password: String): LoginResponse? {
        return try {
            val loginResponse = apiService.login(User(email, password))

            Log.d(tag, "API Response: $loginResponse")

            val accessToken = loginResponse.data?.accessToken
            if (accessToken != null) {
                val token: String = accessToken.token ?: throw IllegalStateException("Token is null")
                val refreshToken: String = accessToken.expiration ?: throw IllegalStateException("Expiration is null")

                tokenManager.saveToken(token)
                tokenManager.saveRefreshToken(refreshToken)
                loginResponse
            } else {
                Log.e(tag, "AccessToken is null in the response")
                null
            }
        } catch (e: Exception) {
            Log.e(tag, "Login failed: ${e.message}", e)
            null
        }
    }
}
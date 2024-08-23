package com.eosdev.yemenu.utils

import com.eosdev.yemenu.data.api.auth.AuthApiService
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val tokenManager: TokenManager,
    private val apiService: AuthApiService
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val newToken = runBlocking {
            val refreshToken = tokenManager.getRefreshToken() ?: return@runBlocking null
            val loginResponse = apiService.refreshToken(refreshToken)

            loginResponse.data?.accessToken?.token
        } ?: return null

        runBlocking { tokenManager.saveToken(newToken) }
        return response.request.newBuilder()
            .header("Authorization", "Bearer $newToken")
            .build()
    }
}

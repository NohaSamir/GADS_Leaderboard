package com.noha.gadsleaderboard.repository

import com.noha.gadsleaderboard.model.User
import com.noha.gadsleaderboard.network.ResultWrapper
import com.noha.gadsleaderboard.network.SubmitAPIs
import com.noha.gadsleaderboard.network.safeApiCall
import com.noha.gadsleaderboard.network.submitAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

val userRepository by lazy {
    UserRepository(submitAPI)
}

class UserRepository(
    private val webService: SubmitAPIs,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun submit(user: User): ResultWrapper<Void> {
        return safeApiCall(dispatcher) {
            webService.submitAsync(
                user.email, user.firstName, user.lastName, user.projectLink
            )
        }
    }
}
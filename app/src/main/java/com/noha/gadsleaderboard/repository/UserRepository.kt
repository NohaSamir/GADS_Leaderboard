package com.noha.gadsleaderboard.repository

import androidx.lifecycle.MutableLiveData
import com.noha.gadsleaderboard.model.ResultWrapper
import com.noha.gadsleaderboard.model.User
import com.noha.gadsleaderboard.network.SubmitAPIs
import com.noha.gadsleaderboard.network.submitAPI
import retrofit2.Call
import retrofit2.Response

val userRepository by lazy {
    UserRepository(submitAPI)
}

class UserRepository(
    private val webService: SubmitAPIs
) {
    fun submit(user: User, resultWrapper: MutableLiveData<ResultWrapper<Any>>) {

        webService.submit(
            user.email, user.firstName, user.lastName, user.projectLink
        ).enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful)
                    resultWrapper.postValue(ResultWrapper.Success(null))
                else
                    resultWrapper.postValue(ResultWrapper.GenericError(response.code(), null))
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                resultWrapper.postValue(ResultWrapper.NetworkError)
            }
        })

    }
}
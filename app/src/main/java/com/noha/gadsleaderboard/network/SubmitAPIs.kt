package com.noha.gadsleaderboard.network

import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

val submitAPI: SubmitAPIs by lazy {
    googleSheetRetrofit.create(SubmitAPIs::class.java)
}

interface SubmitAPIs {

    @FormUrlEncoded
    @POST("forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    fun submitAsync(
        @Field("entry.1824927963") email: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") projectLink: String,
    ): Deferred<Void>
}

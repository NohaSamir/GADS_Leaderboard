package com.noha.gadsleaderboard.network

import com.noha.gadsleaderboard.model.Learner
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

val leadershipAPIs by lazy {
    retrofit.create(LeadershipAPIs::class.java)
}

interface LeadershipAPIs {

    @GET("/api/skilliq")
    fun getSkillIQLeadership(): Deferred<List<Learner>>


    @GET("/api/hours")
    fun getLearningLeadership(): Deferred<List<Learner>>
}
package com.noha.gadsleaderboard.repository

import com.noha.gadsleaderboard.model.Learner
import com.noha.gadsleaderboard.network.LeadershipAPIs
import com.noha.gadsleaderboard.network.ResultWrapper
import com.noha.gadsleaderboard.network.leadershipAPIs
import com.noha.gadsleaderboard.network.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

val leadershipRepository by lazy {
    LeadershipRepository(leadershipAPIs)
}

class LeadershipRepository(
    private val webService: LeadershipAPIs,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getSkillIqLeadership(): ResultWrapper<List<Learner>> {
        return safeApiCall(dispatcher) { webService.getSkillIQLeadership() }
    }

    suspend fun getLearningLeadership(): ResultWrapper<List<Learner>> {
        return safeApiCall(dispatcher) { webService.getLearningLeadership() }
    }
}
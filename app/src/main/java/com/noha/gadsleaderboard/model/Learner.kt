package com.noha.gadsleaderboard.model

import com.google.gson.annotations.SerializedName

data class Learner(
    val name: String,
    @SerializedName(value = "number", alternate = ["hours", "score"])
    val number: Int,
    val country: String,
    val badgeUrl: String
)
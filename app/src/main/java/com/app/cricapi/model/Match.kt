package com.app.cricapi.model

import com.google.gson.annotations.SerializedName

data class Match(
        val unique_id: Int = 0,
        val date: String? = null,
        val dateTimeGMT: String? = null,
        @SerializedName("team-1")
        val team1: String? = null,
        @SerializedName("team-2")
        val team2: String? = null,
        val type: String? = null,
        val squad: Boolean = false,
        val toss_winner_team: String? = null,
        val winner_team: String? = null,
        val matchStarted: Boolean = false
)
package com.app.cricapi.model;

import com.google.gson.annotations.SerializedName;

public class Match {
    private int unique_id;

    private String date;

    private String dateTimeGMT;

    @SerializedName("team-1")
    private String team1;

    @SerializedName("team-2")
    private String team2;

    private String type;

    private boolean squad;

    private String toss_winner_team;

    private String winner_team;

    private boolean matchStarted;

    public Match(int unique_id, String date, String dateTimeGMT, String team1, String team2, String type, boolean squad, String toss_winner_team, String winner_team, boolean matchStarted) {
        this.unique_id = unique_id;
        this.date = date;
        this.dateTimeGMT = dateTimeGMT;
        this.team1 = team1;
        this.team2 = team2;
        this.type = type;
        this.squad = squad;
        this.toss_winner_team = toss_winner_team;
        this.winner_team = winner_team;
        this.matchStarted = matchStarted;
    }

    public int getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(int unique_id) {
        this.unique_id = unique_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateTimeGMT() {
        return dateTimeGMT;
    }

    public void setDateTimeGMT(String dateTimeGMT) {
        this.dateTimeGMT = dateTimeGMT;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSquad() {
        return squad;
    }

    public void setSquad(boolean squad) {
        this.squad = squad;
    }

    public String getToss_winner_team() {
        return toss_winner_team;
    }

    public void setToss_winner_team(String toss_winner_team) {
        this.toss_winner_team = toss_winner_team;
    }

    public String getWinner_team() {
        return winner_team;
    }

    public void setWinner_team(String winner_team) {
        this.winner_team = winner_team;
    }

    public boolean isMatchStarted() {
        return matchStarted;
    }

    public void setMatchStarted(boolean matchStarted) {
        this.matchStarted = matchStarted;
    }
}


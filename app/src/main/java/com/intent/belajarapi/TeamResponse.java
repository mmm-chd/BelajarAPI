package com.intent.belajarapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamResponse {
    @SerializedName("teams")
    private List<ModelClass> teams;

    public List<ModelClass> getTeams() {
        return teams;
    }

    @SerializedName("seasons")
    private List<ModelClass> seasons;

    public List<ModelClass> getSeasons() {
        return seasons;
    }
}

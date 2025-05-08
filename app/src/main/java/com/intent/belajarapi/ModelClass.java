package com.intent.belajarapi;

import com.google.gson.annotations.SerializedName;

public class ModelClass {

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("strBadge")
    private String strBadge;

    @SerializedName("strSeason")
    private String strSeason;

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public String getStrSeason() {
        return strSeason;
    }
}

package com.intent.belajarapi;

import com.google.gson.annotations.SerializedName;

public class ModelClassSpain {

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strBadge")
    private String strBadge;

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getStrBadge() {
        return strBadge;
    }
}

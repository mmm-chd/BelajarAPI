package com.intent.belajarapi;

import com.google.gson.annotations.SerializedName;

public class ModelClass {

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("strBadge")
    private String strBadge;

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strTeamBadge) {
        this.strBadge = strTeamBadge;
    }

}

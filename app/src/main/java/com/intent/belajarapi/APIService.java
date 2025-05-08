package com.intent.belajarapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getModelClasses();
}

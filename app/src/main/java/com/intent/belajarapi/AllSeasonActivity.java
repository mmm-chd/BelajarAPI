package com.intent.belajarapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllSeasonActivity extends AppCompatActivity {

    RecyclerView rvAllSeason;
    ProgressBar pbLoading;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_season);

        rvAllSeason = findViewById(R.id.rvAllSeason);
        pbLoading = findViewById(R.id.pbLoading);
        btnBack = findViewById(R.id.btnBack);

        rvAllSeason.setHasFixedSize(true);
        rvAllSeason.setLayoutManager(new LinearLayoutManager(this));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Hit Api
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<TeamResponse> call = apiService.getModelClassesAllSeason();

        call.enqueue(new Callback<TeamResponse>() {

            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    rvAllSeason.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.GONE);
                    btnBack.setVisibility(View.VISIBLE);
                    List<ModelClass> teamList = response.body().getSeasons();
                    RvAllSeasonLeague adapter = new RvAllSeasonLeague(AllSeasonActivity.this, teamList);
                    rvAllSeason.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable throwable) {
                Toast.makeText(AllSeasonActivity.this, "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
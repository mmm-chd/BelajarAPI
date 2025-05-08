package com.intent.belajarapi;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar pbLoading;
    private List<ModelClass> teamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_la);

        pbLoading = findViewById(R.id.pbLoading);

        recyclerView = findViewById(R.id.rvSpain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Hit Api
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<TeamResponse> call = apiService.getModelClassesSpain();

        call.enqueue(new Callback<TeamResponse>() {

            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    recyclerView.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.GONE);
                    List<ModelClass> teamList = response.body().getTeams();
                    RvSpainAdapter adapter = new RvSpainAdapter(LaActivity.this, teamList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable throwable) {
                Toast.makeText(LaActivity.this, "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
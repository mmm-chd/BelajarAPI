package com.intent.belajarapi;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PremierActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar pbLoading;
    private List<ModelClass> teamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_premier);

        pbLoading = findViewById(R.id.pbLoading);

        recyclerView = findViewById(R.id.rvResult);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Hit Api
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<TeamResponse> call = apiService.getModelClasses();

        call.enqueue(new Callback<TeamResponse>() {

            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful()&& response.body() != null) {
                    recyclerView.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.GONE);
                    List<ModelClass> teamList = response.body().getTeams();
                    RvPremierAdapter adapter = new RvPremierAdapter(PremierActivity.this, teamList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable throwable) {
                Toast.makeText(PremierActivity.this, "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
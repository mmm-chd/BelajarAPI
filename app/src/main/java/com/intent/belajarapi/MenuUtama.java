package com.intent.belajarapi;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class MenuUtama extends AppCompatActivity {

    ImageButton btnPremiere;
    ImageButton btnLa;
    Button btnAllSeason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_utama);

        btnAllSeason = findViewById(R.id.btnAllSeason);
        btnPremiere = findViewById(R.id.btnPremiere);
        btnLa = findViewById(R.id.btnLa);

        // Load image from URL
        Glide.with(this)
                .load("https://b.fssta.com/uploads/application/soccer/competition-logos/EnglishPremierLeague.png")
                .into(btnPremiere);

        Glide.with(this)
                .load("https://cdn.freelogovectors.net/wp-content/uploads/2023/07/laliga-logo-02-freelogovectors.net_.png")
                .into(btnLa);

        btnAllSeason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, AllSeasonActivity.class);
                startActivity(intent);
            }
        });

        btnPremiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, PremierActivity.class);
                startActivity(intent);
            }
        });

        btnLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, LaActivity.class);
                startActivity(intent);
            }
        });

    }
}
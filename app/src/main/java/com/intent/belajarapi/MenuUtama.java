package com.intent.belajarapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class MenuUtama extends AppCompatActivity {

    ImageButton btnPremiere;
    ImageButton btnLa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_utama);

        btnPremiere = findViewById(R.id.btnPremiere);
        btnLa = findViewById(R.id.btnLa);

        // Load image from URL
        Glide.with(this)
                .load("https://b.fssta.com/uploads/application/soccer/competition-logos/EnglishPremierLeague.png")
                .into(btnPremiere);

        Glide.with(this)
                .load("https://cdn.freelogovectors.net/wp-content/uploads/2023/07/laliga-logo-02-freelogovectors.net_.png")
                .into(btnLa);



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
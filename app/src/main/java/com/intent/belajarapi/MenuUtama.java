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
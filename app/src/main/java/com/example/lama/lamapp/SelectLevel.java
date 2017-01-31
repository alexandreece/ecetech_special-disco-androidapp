package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);
    }

    public void goto_GameConfiguration(View view) {
        Intent activityGameConfiguration = new Intent(SelectLevel.this, GameConfiguration.class);
        startActivity(activityGameConfiguration);
        // Faire passer variable de niveau
    }
}

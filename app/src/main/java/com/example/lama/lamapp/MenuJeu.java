package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuJeu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jeu);
    }

    public void goto_GameConfiguration(View view) {
        Intent activityGameConfiguration = new Intent(MenuJeu.this, GameConfiguration.class);
        startActivity(activityGameConfiguration);
    }
}

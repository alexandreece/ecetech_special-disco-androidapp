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

    public void goto_SelectLevel(View view) {
        Intent activitySelectLevel = new Intent(MenuJeu.this, SelectLevel.class);
        startActivity(activitySelectLevel);
    }

    public void goto_Didacticiel(View view) {
        Intent activityDidacticiel = new Intent(MenuJeu.this, Didacticiel.class);
        startActivity(activityDidacticiel);

    }
}

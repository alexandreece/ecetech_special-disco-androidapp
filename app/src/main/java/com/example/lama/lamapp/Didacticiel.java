package com.example.lama.lamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Didacticiel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_didacticiel);
    }

    public void goto_MenuJeu(View view) {
        Intent activityMenu = new Intent(Didacticiel.this, MenuJeu.class);
        startActivity(activityMenu);
    }
}

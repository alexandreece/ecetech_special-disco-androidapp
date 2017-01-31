package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class PlayersName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_name);
    }

    public void goto_SelectLevel(View view) {
        Intent activitySelectLevel = new Intent(PlayersName.this, SelectLevel.class);
        startActivity(activitySelectLevel);
    }

}

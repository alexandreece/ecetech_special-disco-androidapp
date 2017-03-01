package com.example.lama.lamapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_points extends AppCompatActivity {

    TextView mNamePlayerToPlay;
    TextView mTeamName;
    TextView mCurrentRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
/*
        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        int[] PlayerToPlay = game.getPlayerToPlay();

        String NamePlayerToPlay;
        if(PlayerToPlay[0] == 0){
            NamePlayerToPlay = game.getNameJoueurTeamA(PlayerToPlay[1]);
            mNamePlayerToPlay = (TextView) findViewById(R.id.PlayerName);
            mNamePlayerToPlay.setText(NamePlayerToPlay);
        }else if(PlayerToPlay[0] == 1){
            NamePlayerToPlay = game.getNameJoueurTeamB(PlayerToPlay[1]);
            mNamePlayerToPlay = (TextView) findViewById(R.id.PlayerName);
            mNamePlayerToPlay.setText(NamePlayerToPlay);
        }
*/
    }
}

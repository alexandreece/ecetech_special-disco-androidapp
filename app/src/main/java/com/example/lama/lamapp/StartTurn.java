package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartTurn extends AppCompatActivity {

    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_turn);

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        String text;


        int[] PlayerToPlay = new int[2];
        PlayerToPlay = game.getPlayerToPlay();

        if(PlayerToPlay[0] == 0){

            text = game.getNameJoueurTeamA(PlayerToPlay[1]);
            mText = (TextView) findViewById(R.id.text_player);
            mText.setText(text);

            text = game.getNameTeamA();
            mText = (TextView) findViewById(R.id.text_team);
            mText.setText(text);

        }else if(PlayerToPlay[0] == 1){

            text = game.getNameJoueurTeamB(PlayerToPlay[1]);
            mText = (TextView) findViewById(R.id.text_player);
            mText.setText(text);

            text = game.getNameTeamB();
            mText = (TextView) findViewById(R.id.text_team);
            mText.setText(text);

        }else{

            text = "Null";
            mText = (TextView) findViewById(R.id.text_player);
            mText.setText(text);

            text = "Null";
            mText = (TextView) findViewById(R.id.text_team);
            mText.setText(text);
        }
    }

    public void goto_PlayGame(View view) {
        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        Intent intent_next = new Intent(StartTurn.this, PlayGame.class);
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }

}
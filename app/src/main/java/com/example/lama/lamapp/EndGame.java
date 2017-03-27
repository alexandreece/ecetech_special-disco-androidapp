package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        // SAVE DATA

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        Log.i("End","Game");

        String text;

        if(game.getWinRoundTeamA() > game.getWinRoundTeamB()) {
            text = game.getNameTeamA() + " remporte la partie !";
            mText = (TextView) findViewById(R.id.text_winner);
            mText.setText(text);
        } else if(game.getWinRoundTeamA() < game.getWinRoundTeamB()) {
            text = game.getNameTeamB() + " remporte la partie !";
            mText = (TextView) findViewById(R.id.text_winner);
            mText.setText(text);
        } else if(game.getWinRoundTeamA() == game.getWinRoundTeamB()) {
            text = "Match nul !";
            mText = (TextView) findViewById(R.id.text_winner);
            mText.setText(text);
        }
    }

    public void goto_Rematch(View view) {
        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        game.setCurrentRound(0);
        game.setNbPointRoundTeamA(0);
        game.setNbPointRoundTeamB(0);
        game.setNbPointsTurn(0);
        game.setCurrentWord(0);
        game.setCount(0);
        game.setQuit(0);

        Intent intent_next = new Intent(EndGame.this, EnterWord2.class);
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }

    public void goto_Main(View view) {
        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        game.setCurrentRound(0);
        game.setNbPointRoundTeamA(0);
        game.setNbPointRoundTeamB(0);
        game.setNbPointsTurn(0);
        game.setCurrentWord(0);
        game.setCount(0);
        game.setQuit(0);

        Intent intent_next = new Intent(EndGame.this, MenuJeu.class);
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }
}
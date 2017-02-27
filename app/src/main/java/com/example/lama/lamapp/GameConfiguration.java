package com.example.lama.lamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class GameConfiguration extends AppCompatActivity {

    private int NbPlayers;
    private int NbWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_configuration);
    }
    public void nbJoueursx2(View view) {

        Intent intent = getIntent();

        Game game = (Game) intent.getSerializableExtra("game");
        NbPlayers = 2;
        game.setNbPlayers(NbPlayers);
        NbWords = 12;
        game.setNbWords(NbWords);
        Log.i("Package",view.getContext().getPackageName());
        Intent intent_next = new Intent("com.example.lama.lamapp.PlayersName");
        intent_next.putExtra("game", game);
        startActivity(intent_next);

    }
    public void nbJoueursx3(View view) {

        Intent intent = getIntent();

        Game game = (Game) intent.getSerializableExtra("game");
        NbPlayers = 3;
        game.setNbPlayers(NbPlayers);
        NbWords = 8;
        game.setNbWords(NbWords);

        Intent intent_next = new Intent("com.example.lama.lamapp.PlayersName");
        intent_next.putExtra("game", game);
        startActivity(intent_next);

    }
    public void nbJoueursx4(View view) {

        Intent intent = getIntent();

        Game game = (Game) intent.getSerializableExtra("game");
        NbPlayers = 4;
        game.setNbPlayers(NbPlayers);
        NbWords = 6;
        game.setNbWords(NbWords);

        Intent intent_next = new Intent("com.example.lama.lamapp.PlayersName");
        intent_next.putExtra("game", game);
        startActivity(intent_next);


    }
    public void nbJoueursx5(View view) {

        Intent intent = getIntent();

        Game game = (Game) intent.getSerializableExtra("game");
        NbPlayers = 5;
        game.setNbPlayers(NbPlayers);
        NbWords = 5;
        game.setNbWords(NbWords);

        Intent intent_next = new Intent("com.example.lama.lamapp.PlayersName");
        intent_next.putExtra("game", game);
        startActivity(intent_next);

    }
}

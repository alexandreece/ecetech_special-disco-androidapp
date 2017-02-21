package com.example.lama.lamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goto_Main(View view) {
        Intent activityMenuJeu = new Intent(Main.this, MenuJeu.class);
        startActivity(activityMenuJeu);
    }

    public void lucasLevel(View view) {
        Intent activitySelectLevel = new Intent(Main.this, SelectLevel.class);
        startActivity(activitySelectLevel);
    }

    public void lucasInGame(View view) {
        Intent activityInGame = new Intent(Main.this, InGame.class);
        startActivity(activityInGame);
    }

    public void adrien(View view) {
     Intent activityRandomWord = new Intent(Main.this, SelectRandomWord.class);
        startActivity(activityRandomWord);
    }

    public void alex(View view) {
        Intent activitySelectWord = new Intent(Main.this, SelectWord.class);
        startActivity(activitySelectWord);
    }

    public void maevaGame(View view) {
        Intent activityRandomWord = new Intent(Main.this, GameConfiguration.class);
        startActivity(activityRandomWord);
    }

    public void maevaPlayers(View view) {
        Intent activityRandomWord = new Intent(Main.this, PlayersName.class);
        startActivity(activityRandomWord);

    }

    public void maevaEnterWord(View view) {
        Intent activityRandomWord = new Intent(Main.this, EnterWord.class);
        startActivity(activityRandomWord);

    }
}
package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void adrien(View view) {
     Intent activityRandomWord = new Intent(Main.this, SelectRandomWord.class);
        startActivity(activityRandomWord);

    }

    public void alex(View view) {
        Intent activityRandomWord = new Intent(Main.this, SelectWord.class);
        startActivity(activityRandomWord);

    }


    public void maevaGame(View view) {
        Intent activityRandomWord = new Intent(Main.this, GameConfiguration.class);
        startActivity(activityRandomWord);

    }
    public void maevaPlayers(View view) {
        Intent activityRandomWord = new Intent(Main.this, PlayersName.class);
        startActivity(activityRandomWord);

    }
}
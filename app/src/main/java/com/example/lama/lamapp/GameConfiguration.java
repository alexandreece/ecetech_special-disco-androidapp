package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameConfiguration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_configuration);
    }
    public void nbJoueursx2(View view) {
        Intent activity2PlayersName = new Intent(GameConfiguration.this, PlayersName.class);
        startActivity(activity2PlayersName);
        // Faire passer la variable du nb de joueurs à l'activité suivante
    }
    public void nbJoueursx3(View view) {
        Intent activity3PlayersName = new Intent(GameConfiguration.this, PlayersName.class);
        startActivity(activity3PlayersName);
        // Faire passer la variable du nb de joueurs à l'activité suivante
    }
    public void nbJoueursx4(View view) {
        Intent activity4PlayersName = new Intent(GameConfiguration.this, PlayersName.class);
        startActivity(activity4PlayersName);
        // Faire passer la variable du nb de joueurs à l'activité suivante
    }
    public void nbJoueursx5(View view) {
        Intent activity5PlayersName = new Intent(GameConfiguration.this, PlayersName.class);
        startActivity(activity5PlayersName);
        // Faire passer la variable du nb de joueurs à l'activité suivante
    }
}

package com.example.lama.lamapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MenuJeu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jeu);
        SharedPreferences sharedPreferences = getSharedPreferences("NBWord", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void goto_SelectLevel(View view) {
        Intent intent = new Intent("com.example.lama.lamapp.SelectLevel");
        Game current_game = new Game();
        intent.putExtra("game_current", current_game);

        Vibrator vibreur = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Log.i("Vibreur", ""+vibreur.hasVibrator());
        long[] pattern = {0, 200, 200, 200, 200, 200};//attente, vibration, attente, vibration etc.
        vibreur.vibrate(pattern, -1); //-1 : pas de répétition

        startActivity(intent);
    }

    public void goto_Didacticiel(View view) {
        Intent activityDidacticiel = new Intent(MenuJeu.this, Didacticiel.class);
        startActivity(activityDidacticiel);
    }

    public void goto_Scores(View view) {
        Intent activityScores = new Intent(MenuJeu.this, ScoreActivity.class);
        startActivity(activityScores);
    }
}

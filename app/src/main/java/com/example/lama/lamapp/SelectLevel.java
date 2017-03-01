package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectLevel extends AppCompatActivity {

    private int level;

    Game game = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);

        // SET GAME VALUE

    }

    public void goto_GameConfiguration_Easy(View view) {
        Intent intent = getIntent();

        Game game = (Game) intent.getSerializableExtra("game_current");
        level = 0;
        game.setLevel(level);

        Intent intent_next = new Intent("com.example.lama.lamapp.GameConfiguration");
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }

    public void goto_GameConfiguration_Intermediate(View view) {
        Intent intent = getIntent();

        Game game = (Game) intent.getSerializableExtra("game_current");
        level = 1;
        game.setLevel(level);

        Intent intent_next = new Intent("com.example.lama.lamapp.GameConfiguration");
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }

    public void goto_GameConfiguration_Hard(View view) {
        Intent intent = getIntent();

        Game game = (Game) intent.getSerializableExtra("game_current");
        level = 2;
        game.setLevel(level);

        Intent intent_next = new Intent("com.example.lama.lamapp.GameConfiguration");
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }

}

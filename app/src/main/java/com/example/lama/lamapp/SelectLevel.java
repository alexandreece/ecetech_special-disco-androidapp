package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectLevel extends AppCompatActivity {

    private int level;

    Game game = this.returnObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);
    }

    public void goto_GameConfiguration_Easy(View view) {
        level = 0;
        game.setLevel(level);
        Intent activityGameConfiguration = new Intent(SelectLevel.this, GameConfiguration.class);
        startActivity(activityGameConfiguration);
    }

    public void goto_GameConfiguration_Intermediate(View view) {
        level = 1;
        game.setLevel(level);
        Intent activityGameConfiguration = new Intent(SelectLevel.this, GameConfiguration.class);
        startActivity(activityGameConfiguration);
    }

    public void goto_GameConfiguration_Hard(View view) {
        level = 2;
        game.setLevel(level);
        Intent activityGameConfiguration = new Intent(SelectLevel.this, GameConfiguration.class);
        startActivity(activityGameConfiguration);
    }

    private Game returnObject(){
        MenuJeu MenuJeuObject = new MenuJeu();
        return MenuJeuObject.current_game;
    }

}

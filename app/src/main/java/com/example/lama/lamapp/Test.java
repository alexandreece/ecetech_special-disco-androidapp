package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.lama.lamapp.DAOs.Joueur;
import java.util.List;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        // GET AND PRINT ALL DATA

        String Joueur_TeamA;
        String Joueur_TeamB;

        String text_Object = "";

        text_Object = text_Object + "Team A :     Team B :";

        int i;

        for(i = 0; i <= game.getNbPlayers()-1; i++){
            Joueur_TeamA = game.getNameJoueurTeamA(i);
            Joueur_TeamB = game.getNameJoueurTeamB(i);
            text_Object = text_Object + "\n" + Joueur_TeamA + "        " + Joueur_TeamB;
        }

        int NbPointsTurn = game.getNbPointsTurn();
        Log.i("TEST 2", "Points : " + game.getNbPointsTurn());
        int NbPointsRoundTeamA= game.getNbPointsRoundTeamA();
        int NbPointsRoundTeamB= game.getNbPointsRoundTeamB();

        text_Object = text_Object + "\n\nNbPointsTurn = " + NbPointsTurn;
        text_Object = text_Object + "\n\nNbPointsRoundTeamA = " + NbPointsRoundTeamA + "\nNbPointsRoundTeamB = " + NbPointsRoundTeamB;

        int[] PlayerToPlay = game.getPlayerToPlay();
        text_Object = text_Object + "\n\nPlayerToPlay[0] = " + PlayerToPlay[0] + "\nPlayerToPlay[1] = " + PlayerToPlay[1] + "\n";

        String NamePlayerToPlay;
        if(PlayerToPlay[0] == 0){
            NamePlayerToPlay = game.getNameJoueurTeamA(PlayerToPlay[1]);
            text_Object = text_Object + "\nNamePlayerToPlay = " + NamePlayerToPlay;
        }else if(PlayerToPlay[0] == 1){
            NamePlayerToPlay = game.getNameJoueurTeamB(PlayerToPlay[1]);
            text_Object = text_Object + "\nNamePlayerToPlay = " + NamePlayerToPlay;
        }

        TextView mConfigurationText;
        mConfigurationText = (TextView) findViewById(R.id.TestText);
        mConfigurationText.setText(text_Object);
    }

    public void goto_TestFragmentActivity(View view) {
        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        Intent intent_next = new Intent(Test.this, TestFragmentActivity.class);
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }
}
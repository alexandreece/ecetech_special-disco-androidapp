package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        // SET TEAMS' NAMES AND PLAYERS' NAMES

        String TeamA_Name;
        String TeamB_Name;

        TeamA_Name = "Lamalmenée";
        TeamB_Name = "Lamarquise";
        game.setNameTeamA(TeamA_Name);
        game.setNameTeamB(TeamB_Name);

        int NbPlayers = game.getNbPlayers();

        int i;

        for (i = 0; i <= NbPlayers-1; i++) {
            Joueur TeamA_Joueur = new Joueur();
            Joueur TeamB_Joueur = new Joueur();

            String j = Integer.toString(i+1);
            String TeamA_Joueur_X = "Team A Joueur " + j;
            String TeamB_Joueur_X = "Team B Joueur " + j;

            TeamA_Joueur.setNomJoueur(TeamA_Joueur_X);
            TeamB_Joueur.setNomJoueur(TeamB_Joueur_X);

            game.addPlayerTeamA(TeamA_Joueur);
            game.addPlayerTeamB(TeamB_Joueur);
        }

        // GET AND PRINT ALL DATA

        int IntValue = game.getLevel();
        String IntText = Integer.toString(IntValue);
        String text_Object = "\nNbLevel = " + IntText;

        IntValue = game.getNbPlayers();
        IntText = Integer.toString(IntValue);
        text_Object = text_Object + "\nNbPlayers = " + IntText;

        IntValue = game.getNbWords();
        IntText = Integer.toString(IntValue);
        text_Object = text_Object + "\nNbWords = " + IntText;

        String TextValue = game.getNameTeamA();
        text_Object = text_Object + "\n\nName Team A = " + TextValue;


        TextValue = game.getNameTeamB();
        text_Object = text_Object + "\nName Team B = " + TextValue;

        List<Joueur> List_Joueurs_TeamA = game.getTeamA_List_Joueurs();
        List<Joueur> List_Joueurs_TeamB = game.getTeamB_List_Joueurs();

        String Joueur_TeamA;
        String Joueur_TeamB;

        int SizeTeamA = List_Joueurs_TeamA.size();
        int SizeTeamB = List_Joueurs_TeamB.size();

        text_Object = text_Object + "\n\nSize Team A = " + SizeTeamA + "\nSize Team B = " + SizeTeamB;

        text_Object = text_Object + "\n\nTeam A :                       Team B :";

        for(i = 0; i <= game.getNbPlayers()-1; i++){
            Joueur_TeamA = game.getNameJoueurTeamA(i);
            Joueur_TeamB = game.getNameJoueurTeamB(i);
            text_Object = text_Object + "\n" + Joueur_TeamA + "        " + Joueur_TeamB;
        }

        TextView mConfigurationText;
        mConfigurationText = (TextView) findViewById(R.id.TestText);
        mConfigurationText.setText(text_Object);
    }
}
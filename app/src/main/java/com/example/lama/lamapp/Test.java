package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        // SET TEAMS' NAMES AND PLAYERS' NAMES

        List<Joueur> TeamA_List_Joueurs = new ArrayList<Joueur>();
        List<Joueur> TeamB_List_Joueurs = new ArrayList<Joueur>();
        String TeamA_Name;
        String TeamB_Name;

        TeamA_Name = "Lamalmenée";
        TeamB_Name = "Lamarquise";
        game.setNameTeamA(TeamA_Name);
        game.setNameTeamB(TeamB_Name);

        int NbPlayers = game.getNbPlayers();

        for(int i = 0; i <= NbPlayers; i++){
            Joueur TeamA_Joueur = new Joueur();
            Joueur TeamB_Joueur = new Joueur();

            String j = Integer.toString(i);
            String TeamA_Joueur_X = "Team A Joueur " + j;
            String TeamB_Joueur_X = "Team B Joueur " + j;

            TeamA_Joueur.setNomJoueur(TeamA_Joueur_X);
            TeamB_Joueur.setNomJoueur(TeamB_Joueur_X);

            game.addPlayer(TeamA_List_Joueurs, TeamA_Joueur);
            game.addPlayer(TeamB_List_Joueurs, TeamB_Joueur);
        }


        // GET AND PRINT ALL DATA

        int IntValue = game.getLevel();
        String IntText = Integer.toString(IntValue);
        String text_Object = "NbLevel = " + IntText;

        IntValue = game.getNbPlayers();
        IntText = Integer.toString(IntValue);
        text_Object = text_Object + "\nNbPlayers = " + IntText;

        IntValue = game.getNbWords();
        IntText = Integer.toString(IntValue);
        text_Object = text_Object + "\nNbWords = " + IntText;

        String TextValue = game.getNameTeamA();
        text_Object = text_Object + "\nName Team A = " + TextValue;


        TextValue = game.getNameTeamB();
        text_Object = text_Object + "\nName Team B = " + TextValue;

        List<Joueur> List_Joueurs_TeamA = game.getTeamA_List_Joueurs();
        List<Joueur> List_Joueurs_TeamB = game.getTeamB_List_Joueurs();

        String Joueur_TeamA;
        String Joueur_TeamB;

        text_Object = text_Object + "\n\nTeam A : \t\t Team B :";
/*
        for(int i = 0; i <= game.getNbPlayers(); i++){
            Joueur_TeamA = game.getNameJoueur(List_Joueurs_TeamA, i);
            Joueur_TeamB = game.getNameJoueur(List_Joueurs_TeamB, i);
            text_Object = text_Object + "\n" + Joueur_TeamA + "\t" + Joueur_TeamB;
        }
*/
        TextView mConfigurationText;
        mConfigurationText = (TextView) findViewById(R.id.TestText);
        mConfigurationText.setText(text_Object);
    }
}

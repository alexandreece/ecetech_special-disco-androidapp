package com.example.lama.lamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lama.lamapp.DAOs.Joueur;


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

    public void testFragment(View view) {
        Intent activitySelectLevel = new Intent(Main.this, Test.class);
        Game game = new Game();

        // SET TEAMS' NAMES AND PLAYERS' NAMES

        int Level = 3;
        game.setLevel(Level);
        int NbPlayers = 4;
        game.setNbPlayers(NbPlayers);
        int NbWords = 6;
        game.setNbWords(NbWords);
        int CurrentRound = 1;
        game.setCurrentRound(CurrentRound);

        String TeamA_Name = "Lamalmenée";
        String TeamB_Name = "Lamarquise";
        game.setNameTeamA(TeamA_Name);
        game.setNameTeamB(TeamB_Name);

        int i;

        for (i = 0; i <= NbPlayers-1; i++) {
            Joueur TeamA_Joueur = new Joueur();
            Joueur TeamB_Joueur = new Joueur();

            String j = Integer.toString(i+1);
            String TeamA_Joueur_X = "Joueur " + j + "A";
            String TeamB_Joueur_X = "Joueur " + j + "B";

            TeamA_Joueur.setNomJoueur(TeamA_Joueur_X);
            TeamB_Joueur.setNomJoueur(TeamB_Joueur_X);

            game.addPlayerTeamA(TeamA_Joueur);
            game.addPlayerTeamB(TeamB_Joueur);
        }
        String[] pWords = {"Chien", "Chat", "Poisson", "Ours", "Lombric", "Loup", "Chèvre", "Hyène", "Pigeon", "Aigle", "Souris", "Rat", "Grenouille", "Vache"};
        for(int j = 0; j < pWords.length; j++){
            game.addWord(pWords[j]);
        }

        activitySelectLevel.putExtra("game", game);
        startActivity(activitySelectLevel);
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
    public void playername(View view) {
        Intent activityRandomWord = new Intent(Main.this, PlayerNameAdapter.class);
        startActivity(activityRandomWord);

    }
}
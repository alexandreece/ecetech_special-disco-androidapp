package com.example.lama.lamapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VRSTL on 31/01/2017.
 */

public class Game {

    //Instantiation des variables
    int Level;
    int NbPlayers;
    int NbWords;
    List<List<String>> NameTeam = new ArrayList<List<String>>();
    List<String> Words = new ArrayList<String>();

    int NbPointsTurn;
    int NbPointsRound;

    // Constructeur
    public Game() {
        Level = 0;
        NbPlayers = 0;
        NbWords = 0;
        NbPointsTurn = 0;
        NbPointsRound = 0;
    }

    // Getters
    public int getLevel() { return Level; }
    public int getNbPlayers() { return NbPlayers; }
    public int getNbWords() { return NbWords; }
    public List<List<String>> getNameTeam() { return NameTeam; }
    public List<String> getWords() { return Words; }
    public int getNbPointsTurn() { return NbPointsTurn; }
    public int getNbPointsRound() { return NbPointsRound; }

    // Setters
    public void setLevel(int pLevel){ Level = pLevel;}


}

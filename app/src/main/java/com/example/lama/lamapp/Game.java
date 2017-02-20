package com.example.lama.lamapp;

import com.example.lama.lamapp.DAOs.Equipe;
import com.example.lama.lamapp.DAOs.Joueur;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by VRSTL on 31/01/2017.
 */

public class Game {

    //Instantiation des variables
    int Level;

    int NbPlayers;

    String TeamA;
    String TeamB;

    List<Joueur> TeamA_List_Joueurs = new ArrayList<Joueur>();
    List<Joueur> TeamB_List_Joueurs = new ArrayList<Joueur>();

    int NbWords;
    List<String> Words = new ArrayList<String>();

    int NbPointsTurn;
    int NbPointsRound;

    int JoueurID;

    // Constructeur
    public Game() {
        Level = 0;
        NbPlayers = 0;
        TeamA = "";
        TeamB = "";
        NbWords = 0;
        NbPointsTurn = 0;
        NbPointsRound = 0;
        int JoueurID = 0;
    }

    // Getters
    public int getLevel() {
        return Level;
    }

    public int getNbPlayers() {
        return NbPlayers;
    }

    public String getNameTeamA() {
        return TeamA;
    }
    public String getNameTeamB() {
        return TeamB;
    }

    public List<Joueur> getTeamA_List_Joueurs() { return TeamA_List_Joueurs; }
    public List<Joueur> getTeamB_List_Joueurs() { return TeamB_List_Joueurs; }

   // public List<Joueur>

    public int getNbWords() {
        return NbWords;
    }
    public List<String> getWords() {
        return Words;
    }

    public int getNbPointsTurn() {
        return NbPointsTurn;
    }
    public int getNbPointsRound() {
        return NbPointsRound;
    }

    // Setters
    public void setLevel(int pLevel){
        Level = pLevel;
    }
    public void setNbPlayers(int pNbPlayers){ pNbPlayers = NbPlayers;}
    public void setNameTeam(String pNameTeam){
        //NameTeam = pNameTeam;
        //this.
    }
    public void setNbWords(int pNbWords){
        NbWords = pNbWords;
    }
    public void setWords(ArrayList<String> pWords){
        Words = pWords;
    }
    public void setNbPointsTurn(int pNbPointsTurn){
        NbPointsTurn = pNbPointsTurn;
    }
    public void setNbPointRound(int pNbPointsRound){
        NbPointsRound = pNbPointsRound;
    }
    public void addNamePlayer(int pTeamID, String pNamePlayer){
       // NameTeam.add(pTeamID, pNamePlayer);
    }

}

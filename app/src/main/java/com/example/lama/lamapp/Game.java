package com.example.lama.lamapp;

import com.example.lama.lamapp.DAOs.Equipe;
import com.example.lama.lamapp.DAOs.Joueur;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by VRSTL on 31/01/2017.
 */

public class Game {

    // ----- INSTANTIATION ----- //
    int Level;

    int NbPlayers;

    String TeamA;
    String TeamB;

    List<Joueur> TeamA_List_Joueurs = new ArrayList<Joueur>();
    List<Joueur> TeamB_List_Joueurs = new ArrayList<Joueur>();

    int NbWords;
    List<String> Words_List = new ArrayList<String>();
    String Word;

    int NbPointsTurn;
    int NbPointsRound;

    // ----- CONSTRUCTOR ----- //
    public Game() {
        Level = 0;
        NbPlayers = 0;
        TeamA = "";
        TeamB = "";
        NbWords = 0;
        Word = "";
        NbPointsTurn = 0;
        NbPointsRound = 0;
    }

    // ----- GETTERS ----- //
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

   public String getNameJoueur(List<Joueur> pList_Joueurs, int pJoueurID) {
       Joueur Joueur = pList_Joueurs.get(pJoueurID);
       String JoueurName = Joueur.getNomJoueur();
       return JoueurName;
   }

    public int getNbWords() {
        return NbWords;
    }
    public List<String> getWords_List() {
        return this.Words_List;
    }
    public String getWord(int pWordID){ return this.Words_List.get(pWordID); }

    public int getNbPointsTurn() {
        return NbPointsTurn;
    }
    public int getNbPointsRound() {
        return NbPointsRound;
    }

    // ----- SETTERS ----- //
    public void setLevel(int pLevel){
        this.Level = pLevel;
    }

    public void setNbPlayers(int pNbPlayers){ this.NbPlayers = pNbPlayers;}

    public void setNameTeamA(String pNameTeamA){this.TeamA = pNameTeamA ;}
    public void setNameTeamB(String pNameTeamB){this.TeamB = pNameTeamB ;}

    public void addPlayer(List<Joueur> pTeam, Joueur pJoueur){ pTeam.add(pJoueur);}

    public void setNbWords(int pNbWords){
        this.NbWords = pNbWords;
    }
    public void addWord(String pWord){
        this.Words_List.add(pWord);
    }

    public void setNbPointsTurn(int pNbPointsTurn){
        NbPointsTurn = pNbPointsTurn;
    }
    public void setNbPointRound(int pNbPointsRound){
        NbPointsRound = pNbPointsRound;
    }
}

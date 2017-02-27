package com.example.lama.lamapp;

import com.example.lama.lamapp.DAOs.Equipe;
import com.example.lama.lamapp.DAOs.Joueur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Game implements Serializable{

    // ----- INSTANTIATION ----- //
    int Level;

    int NbPlayers;

    String TeamA;
    String TeamB;

    ArrayList<Joueur> TeamA_List_Joueurs = new ArrayList<Joueur>();
    ArrayList<Joueur> TeamB_List_Joueurs = new ArrayList<Joueur>();

    int NbWords;
    ArrayList<String> Words_List = new ArrayList<String>();
    String Word;

    int NbPointsTurnTeamA;
    int NbPointsTurnTeamB;
    int NbPointsRoundTeamA;
    int NbPointsRoundTeamB;

    // ----- CONSTRUCTOR ----- //
    public Game() {
        Level = 0;
        NbPlayers = 0;
        TeamA = "";
        TeamB = "";
        NbWords = 0;
        Word = "";
        NbPointsTurnTeamA = 0;
        NbPointsTurnTeamB = 0;
        NbPointsRoundTeamA = 0;
        NbPointsRoundTeamB = 0;
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

    public ArrayList<Joueur> getTeamA_List_Joueurs() { return TeamA_List_Joueurs; }
    public ArrayList<Joueur> getTeamB_List_Joueurs() { return TeamB_List_Joueurs; }

    public String getNameJoueurTeamA(int pJoueurID) {
       Joueur Joueur = TeamA_List_Joueurs.get(pJoueurID);
       String JoueurName = Joueur.getNomJoueur();
       return JoueurName;
    }

    public String getNameJoueurTeamB(int pJoueurID) {
        Joueur Joueur = TeamB_List_Joueurs.get(pJoueurID);
        String JoueurName = Joueur.getNomJoueur();
        return JoueurName;
    }

    public int getNbWords() {
        return NbWords;
    }
    public ArrayList<String> getWords_List() {
        return this.Words_List;
    }
    public String getWord(int pWordID){ return this.Words_List.get(pWordID); }

    public int getNbPointsTurnTeamA() { return NbPointsTurnTeamA; }
    public int getNbPointsTurnTeamB() { return NbPointsTurnTeamB; }
    public int getNbPointsRoundTeamA() {
        return NbPointsRoundTeamA;
    }
    public int getNbPointsRoundTeamB() {
        return NbPointsRoundTeamB;
    }

    // ----- SETTERS ----- //
    public void setLevel(int pLevel){
        this.Level = pLevel;
    }

    public void setNbPlayers(int pNbPlayers){ this.NbPlayers = pNbPlayers;}

    public void setNameTeamA(String pNameTeamA){this.TeamA = pNameTeamA ;}
    public void setNameTeamB(String pNameTeamB){this.TeamB = pNameTeamB ;}

    public void addTeamA(ArrayList<Joueur> A){this.TeamA_List_Joueurs = A;}
    public void addTeamB(ArrayList<Joueur> B){this.TeamA_List_Joueurs = B;}

    public void addPlayerTeamA(Joueur pJoueur){ this.TeamA_List_Joueurs.add(pJoueur);}
    public void addPlayerTeamB(Joueur pJoueur){ this.TeamB_List_Joueurs.add(pJoueur);}

    public void setNbWords(int pNbWords){
        this.NbWords = pNbWords;
    }
    public void addWord(String pWord){
        this.Words_List.add(pWord);
    }

    public void setNbPointsTurnTeamA(int pNbPointsTurn){
        NbPointsTurnTeamA = pNbPointsTurn;
    }
    public void setNbPointsTurnTeamB(int pNbPointsTurn){
        NbPointsTurnTeamB = pNbPointsTurn;
    }
    public void setNbPointRoundTeamA(int pNbPointsRound){
        NbPointsRoundTeamA = pNbPointsRound;
    }
    public void setNbPointRoundTeamB(int pNbPointsRound){
        NbPointsRoundTeamB = pNbPointsRound;
    }
}

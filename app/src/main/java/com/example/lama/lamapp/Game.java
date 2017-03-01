package com.example.lama.lamapp;

import com.example.lama.lamapp.DAOs.Joueur;
import java.io.Serializable;
import java.util.ArrayList;

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
    ArrayList<String> Words_Current_List = new ArrayList<String>();
    String Word;

    int CurrentRound;
    int[] PlayerToPlay = new int[2];
    int NbPointsTurn;
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
        CurrentRound = 0;
        PlayerToPlay[0] = 0;
        PlayerToPlay[1] = 0;
        NbPointsTurn = 0;
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
    public ArrayList<String> getWords_Current_List() {
        return this.Words_Current_List;
    }
    public String getWord(int pWordID) { return this.Words_List.get(pWordID); }
    public String getWordCurrentList(int pWordID) { return this.Words_Current_List.get(pWordID); }

    public int[] getPlayerToPlay() { return this.PlayerToPlay; }

    public int getCurrentRound(){ return CurrentRound; }
    public int getNbPointsTurn()  { return NbPointsTurn; }
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
    public void addTeamB(ArrayList<Joueur> B){this.TeamB_List_Joueurs = B;}

    public void addPlayerTeamA(Joueur pJoueur){ this.TeamA_List_Joueurs.add(pJoueur);}
    public void addPlayerTeamB(Joueur pJoueur){ this.TeamB_List_Joueurs.add(pJoueur);}

    public void setNbWords(int pNbWords){
        this.NbWords = pNbWords;
    }
    public void addWord(String pWord){
        this.Words_List.add(pWord);
    }

    public void setCurrentRound(int pCurrentRound){ CurrentRound = pCurrentRound; }
    public void setPlayerToPlay(int[] pPlayerToPlay){ PlayerToPlay = pPlayerToPlay; }
    public void setNbPointsTurn(int pNbPointsTurn){
        NbPointsTurn = pNbPointsTurn;
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

    @Override
    public String toString() {
        return "Game{" +
                "Level=" + Level +
                ", NbPlayers=" + NbPlayers +
                ", TeamA='" + TeamA + '\'' +
                ", TeamB='" + TeamB + '\'' +
                ", TeamA_List_Joueurs=" + TeamA_List_Joueurs +
                ", TeamB_List_Joueurs=" + TeamB_List_Joueurs +
                ", NbWords=" + NbWords +
                ", Words_List=" + Words_List +
                ", Word='" + Word + '\'' +
                ", NbPointsTurnTeamA=" + NbPointsTurnTeamA +
                ", NbPointsTurnTeamB=" + NbPointsTurnTeamB +
                ", NbPointsRoundTeamA=" + NbPointsRoundTeamA +
                ", NbPointsRoundTeamB=" + NbPointsRoundTeamB +
                '}';
    }
}

package com.example.lama.lamapp.SQLite;

/**
 * Created by alex on 06/12/2016.
 */

public class Score {

    private int idScore;
    private int score;
    private String dateJeu;
    private int niveauJeu;
    private int Equipes_idEquipe;

    public Score(int idScore, int score, String dateJeu, int niveauJeu, int equipes_idEquipe) {
        this.idScore = idScore;
        this.score = score;
        this.dateJeu = dateJeu;
        this.niveauJeu = niveauJeu;
        Equipes_idEquipe = equipes_idEquipe;
    }

    public Score(int score, String dateJeu, int niveauJeu, int equipes_idEquipe) {
        this.score = score;
        this.dateJeu = dateJeu;
        this.niveauJeu = niveauJeu;
        Equipes_idEquipe = equipes_idEquipe;
    }

    public Score() {
    }

    public int getIdScore() {
        return idScore;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDateJeu() {
        return dateJeu;
    }

    public void setDateJeu(String dateJeu) {
        this.dateJeu = dateJeu;
    }

    public int getNiveauJeu() {
        return niveauJeu;
    }

    public void setNiveauJeu(int niveauJeu) {
        this.niveauJeu = niveauJeu;
    }

    public int getEquipes_idEquipe() {
        return Equipes_idEquipe;
    }

    public void setEquipes_idEquipe(int equipes_idEquipe) {
        Equipes_idEquipe = equipes_idEquipe;
    }

    @Override
    public String toString() {
        return "Score{" +
                "idScore=" + idScore +
                ", score=" + score +
                ", dateJeu='" + dateJeu + '\'' +
                ", niveauJeu=" + niveauJeu +
                ", Equipes_idEquipe=" + Equipes_idEquipe +
                '}';
    }
}
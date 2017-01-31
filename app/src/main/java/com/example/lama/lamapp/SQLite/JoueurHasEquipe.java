package com.example.lama.lamapp.SQLite;

/**
 * Created by alex on 06/12/2016.
 */

public class JoueurHasEquipe {

    private int idJoueur;
    private int idEquipe;

    public JoueurHasEquipe(int idJoueur, int idEquipe) {
        this.idJoueur = idJoueur;
        this.idEquipe = idEquipe;
    }

    public JoueurHasEquipe() {
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    @Override
    public String toString() {
        return "JoueurHasEquipe{" +
                "idJoueur=" + idJoueur +
                ", idEquipe=" + idEquipe +
                '}';
    }
}

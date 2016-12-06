package SQLite;

/**
 * Created by alex on 06/12/2016.
 */

public class Joueur {

    private int idJoueur;
    private String nomJoueur;

    public Joueur(int idJoueur, String nomJoueur) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "idJoueur=" + idJoueur +
                ", nomJoueur='" + nomJoueur + '\'' +
                '}';
    }
}
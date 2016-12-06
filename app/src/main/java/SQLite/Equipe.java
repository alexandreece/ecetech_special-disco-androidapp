package SQLite;

/**
 * Created by alex on 06/12/2016.
 */

public class Equipe {

    private int idEquipe;
    private String nomEquipe;
    private int nbJoueurs;

    public Equipe(String nomEquipe, int nbJoueurs) {
        this.nomEquipe = nomEquipe;
        this.nbJoueurs = nbJoueurs;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "idEquipe=" + idEquipe +
                ", nomEquipe='" + nomEquipe + '\'' +
                ", nbJoueurs=" + nbJoueurs +
                '}';
    }
}

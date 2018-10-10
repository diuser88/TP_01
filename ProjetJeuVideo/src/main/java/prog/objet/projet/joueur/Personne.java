package prog.objet.projet.joueur;

import lombok.ToString;

public abstract class Personne {

    protected String nomJoueur;

    protected Personne(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    protected Personne(){}

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }
}

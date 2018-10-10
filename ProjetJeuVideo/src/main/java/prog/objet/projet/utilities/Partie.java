package prog.objet.projet.utilities;

import lombok.Getter;
import lombok.Setter;
import prog.objet.projet.Jeu;
import prog.objet.projet.joueur.Joueur;

public class Partie<T> {

    @Getter @Setter
    private Joueur joueur;

    private T jeu;

    public Partie(Joueur joueur){
        this.joueur = joueur;
    }
}

package prog.objet.projet.joueur;

import prog.objet.projet.bingo.AnnonceCard;
import prog.objet.projet.bingo.BingoBall;
import prog.objet.projet.bingo.BingoCard;

public class Annonceur extends Personne{
    private AnnonceCard card;

    public Annonceur() {
        this.nomJoueur = "Annonceur";
        this.card = new AnnonceCard();
    }

    public String afficherCard(){
        return this.card.toString();
    }

    public void ajouterBallCarteAnnonseur(BingoBall bingoBall){
        this.card.add(bingoBall);
    }
}

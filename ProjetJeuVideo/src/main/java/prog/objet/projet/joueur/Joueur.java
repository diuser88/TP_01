package prog.objet.projet.joueur;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import prog.objet.projet.bingo.BingoBall;
import prog.objet.projet.bingo.BingoCard;

import java.util.ArrayList;
import java.util.List;

public class Joueur extends Personne{
    @Getter
    private List<BingoCard> cards;

    @Getter
    @Setter
    private int nb_parties_jouees;

    @Getter
    @Setter
    private int nb_victoires;


    public Joueur(){
        super();
        this.nb_parties_jouees = 0;
        this.nb_victoires = 0;
    }

    public void verifierCarts(BingoBall bingoBall){
        for (BingoCard card: this.cards
             ) {
            card.entrerBallinCarte(bingoBall);
        }
    }

    public Joueur(String nom){
        super(nom);
        this.nb_parties_jouees = 0;
        this.nb_victoires = 0;
    }

    public void ajouterCards(){
        if(this.cards.size() != 0){
            this.cards.clear();
        }
        for(int i = 0; i < 4; i ++){
            this.cards.add(new BingoCard(i+1));
        }
    }

    public String afficherCard(int numeroCard){
        return this.nomJoueur +
                "\n" +
                "Card Number : " +
                (numeroCard + 1) +
                "\n" +
                this.cards.get(numeroCard);
    }

    public List<BingoCard> getCards() {
        return cards;
    }

    public void setCards(List<BingoCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nomJoueur='" + nomJoueur + '\'' +
                '}';
    }

}

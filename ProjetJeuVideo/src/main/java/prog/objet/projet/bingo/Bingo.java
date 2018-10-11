package prog.objet.projet.bingo;


import prog.objet.projet.Jeu;
import prog.objet.projet.joueur.Joueur;
import prog.objet.projet.utilities.Utilities;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bingo extends Jeu {

    //Data Members
    private Boullier boullier;
    private List<BingoCard> cardsDejoueur;
    private AnnonceCard annonceCard;

    public Bingo(Joueur joueur){
        this.nomDuJeu = "Bingo";
        this.dateCreation = "2018-10-05";
        this.auteur = "Diulgherov Serghei";
        this.boullier = new Boullier();
        this.annonceCard = new AnnonceCard();
        this.cardsDejoueur = new ArrayList<BingoCard>();
    }



    public void jouerPartie(){
        System.out.println(this.menu());
        int choix = 0;
        Scanner reader = new Scanner(System.in);
        int nombrecards = 0;
        while (choix != 5){
            choix = reader.nextInt();
            switch (choix){
                case 1:
                    this.cardsDejoueur.clear();
                    this.annonceCard.clearBoard();
                    this.boullier.clearBoard();
                    System.out.println("Une nouvelle partie est Initialisé. \n" +
                            "Veuillez choisir le nombre de cards désiré (maximum 4): ");
                    nombrecards = reader.nextInt();
                    while (!Utilities.isNomberValide(nombrecards)){
                        System.out.println("Entrez un nombre valide: ");
                        nombrecards = reader.nextInt();
                    }
                    for (int i = 1; i <= nombrecards; i++){
                        this.cardsDejoueur.add(new BingoCard(i));
                    }
                    System.out.println(this.menu());
                    break;

                case 2:
                    if(this.cardsDejoueur.size() != 0){
                        this.visualiserUneCarte();
                    }
                    else{
                        System.out.println("Aucun jeu de bingo n'a été initialisé.");
                    }
                    System.out.println(this.menu());
                    break;

                case 3:
                    if(this.cardsDejoueur.size() == 0){
                        System.out.println("Aucun jeu de bingo n'a été initialisé.");
                    }
                    else{
                        this.visualiserCarteAnnonceur();
                    }
                    System.out.println(this.menu());
                    break;

                case 4:
                    if(this.cardsDejoueur.size() > 0 && !this.checkIfGagnant()){
                        this.tirerUneBoule();
                    }
                    else if (this.cardsDejoueur.size() == 0){
                        System.out.println("Aucun jeu de bingo n'a été initialisé.");
                    }
                    else
                    {
                        System.out.println("La partie est terminée, veuillez verifier vos cartes!");
                    }
                    System.out.println(this.menu());
                    break;
            }


        }
    }

    private boolean checkIfGagnant(){
        for (BingoCard card: this.cardsDejoueur
             ) {
            if(Utilities.isGagnante(card)){
                return true;
            }
        }
        return false;
    }

    private void visualiserUneCarte(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Choisissez le numéro de carte pour l'affichage: ");
        int numeroCarte = reader.nextInt();

        while (!Utilities.isNrCarteValide(numeroCarte)){

            try {
                String test = reader.next();
                numeroCarte = Integer.parseInt(test);

            }catch (NumberFormatException ex){
                System.out.println("Choisissez le numéro de carte valide(1 - )" +
                                    this.cardsDejoueur.size() + ": ");
            }
        }
        this.afficherCard(numeroCarte);
    }

    private void afficherCard(int numeroCard){
        String card =  "**************************\n" +
                "*\t Card Number : " +
                numeroCard + "\t *\n" +
                "**************************\n" +
                this.cardsDejoueur.get(numeroCard - 1);
        System.out.println(card);
    }

    private void visualiserCarteAnnonceur(){
        System.out.println(this.annonceCard.toString());
    }

    private void checkCardsJoueur(BingoBall bingoBall){
        for (BingoCard card: this.cardsDejoueur
        ) {
            card.enterBallInCard(bingoBall);
        }
    }

    private void tirerUneBoule(){
        BingoBall bingoBall = this.boullier.remove();
        System.out.println(bingoBall);
        this.annonceCard.add(bingoBall);
        this.checkCardsJoueur(bingoBall);
    }

    private String menu(){
        return "\n\tChoisir l'option suivante :\n\n" +
                "\t1-Initialiser une nouvelle partie\n" +
                "\t2-Visualiser une carte\n" +
                "\t3-Visualiser la carte de l'annonceur\n" +
                "\t4-Tirez une boule\n" +
                "\t5-Fin de partie\n";
    }
}

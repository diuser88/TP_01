package prog.objet.projet.bingo;


import lombok.Getter;
import lombok.ToString;
import prog.objet.projet.Jeu;
import prog.objet.projet.joueur.Annonceur;
import prog.objet.projet.joueur.Joueur;
import prog.objet.projet.utilities.Utilities;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bingo extends Jeu {

    private Boullier boullier;
    private List<BingoCard> cardsDejoueur;
    private AnnonceCard annonceCard;

    public Bingo(Joueur joueur){
        this.nomDuJeu = "Bingo";
        this.dateCreation = "2018-10-05";
        this.auteur = "Diulgherov Serghei";
        this.boullier = new Boullier();
        this.annonceCard = new AnnonceCard();


    }



    public void jouerPartie(){
        System.out.println(this.menu());
        int choix = 0;
        Scanner reader = new Scanner(System.in);
        choix = reader.nextInt();
        int nombrecards = 0;
        while (choix != 5){
            switch (choix){
                case 1:
                    if(this.cardsDejoueur != null){
                        this.cardsDejoueur.clear();
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
                        this.annonceCard.clearBoard();
                        this.boullier.clearBoard();
                    }
                    else{
                        System.out.println("Une nouvelle partie est Initialisé. \n" +
                                "Veuillez choisir le nombre de cards désiré (maximum 4): ");
                        nombrecards = reader.nextInt();
                    }
            }

            choix = reader.nextInt();
        }


        this.joueur.setNomJoueur(nomJoueur);
        this.joueur.ajouterCards();
        this.annonceur = new Annonceur();


    }

    public void visualiserUneCarte(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrez le numero de carte: ");
        int nbCarte = 0;

        while (!Utilities.isNrCarteValide(nbCarte)){

            try {
                String test = reader.next();
                nbCarte = Integer.parseInt(test);

            }catch (NumberFormatException ex){
                System.out.println("Entrez un nombre valide: ");
            }
        }

        System.out.println(this.joueur.afficherCard(nbCarte-1));
    }

    public void visualiserCarteAnnonceur(){
        System.out.println(this.annonceur.afficherCard());

    }

    public void tirerUneBoule(){
        BingoBall bingoBall = this.boullier.remove();
        System.out.println(bingoBall);
        this.annonceur.ajouterBallCarteAnnonseur(bingoBall);
        this.joueur.verifierCarts(bingoBall);
    }

    public String menu(){
        return "\tChoisir l'option suivante :\n\n" +
                "\t1-Initialiser une nouvelle partie\n" +
                "\t2-Visualiser une carte\n" +
                "\t3-Visualiser la carte de l'annonceur\n" +
                "\t4-Tirez une boule\n" +
                "\t5-Fin de partie\n";
    }

//
//    Bingo bingo = new Bingo();
//    int choix = 0;
//    Scanner reader = new Scanner(System.in);
//    boolean test = false;
//    Joueur joueur = bingo.getJoueur();
//
//
//        while(choix != 5){
//        System.out.println(bingo.menu());
//
//        choix = reader.nextInt();
//        switch (choix){
//            case 1:
//                bingo.initialiseNouvellePartie();
//                System.out.println("La nouvelle partie est initialisé.");
//                break;
//            case 2:
//                bingo.visualiserUneCarte();
//                break;
//            case 3:
//                bingo.visualiserCarteAnnonceur();
//                break;
//            case 4:
//                bingo.tirerUneBoule();
//                for (BingoCard card: joueur.getCards()
//                ) {
//                    test = Utilities.isGagnante(card);
//                }
//                if(test){
//                    System.out.println("Gagnant");
//                }
//                break;
//            case 5:
//                System.out.println("Merci d'avoir joué en bingo.");
//                break;
//            default:
//                System.out.println("Enrez une valeur valide.");
//        }
//
//
//    }




}

package prog.objet.projet;

import prog.objet.projet.bingo.*;
import prog.objet.projet.bingo.Number;
import prog.objet.projet.blackjack.BlackJack;
import prog.objet.projet.joueur.Joueur;
import prog.objet.projet.pendu.Pendu;
import prog.objet.projet.utilities.Statistique;
import prog.objet.projet.utilities.Utilities;

import java.util.Scanner;


public class Controller {

    public static void main(String[] args) {
        System.out.println("Bonjour !!!\nBienvenue dans les jeux vidéos.");
        System.out.println("--------------------------------------");
        System.out.println("Pour commencer Veuillez entrer le nom de joueur :");
        Scanner reader = new Scanner(System.in);
        String nom = reader.next();
        Joueur joueur = new Joueur(nom);

        int choix = -1;
        while (choix != 0){
            System.out.println(menu());
            choix = reader.nextInt();
            switch (choix){
                case 1:
                    Bingo bingo = new Bingo(joueur);
                    bingo.jouerPartie();
                    break;

                case 2:
                    BlackJack blackJack = new BlackJack();
                    break;

                case 3:
                    Pendu pendu = new Pendu();
                    break;

                case 4:
                    Statistique statistique = new Statistique();
                    break;

                case 0:
                    System.out.println("Goodbye!...");
                    break;

                default:
                    System.out.println("Entrez un nombre valide: ");
                    break;
            }
        }
    }

    public static String menu(){
        String str = "";
        str += "\t  Menu\n";
        str += " --------------------------------\n";
        str += "|\t1 - Bingo \t\t\t\t\t |\n";
        str += "|\t2 - Black Jack\t\t\t\t |\n";
        str += "|\t3 - Pandu\t\t\t\t\t |\n";
        str += "|\t4 - statistiques des jeux\t |\n";
        str += "|\t0 - Quiter\t\t\t\t\t |\n";
        str += " --------------------------------\n";
        return str;
    }
}

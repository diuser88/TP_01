package prog.objet.projet.utilities;

import prog.objet.projet.bingo.BingoCard;

public class Utilities {

    public static boolean isNomberValide(int nombre) {
        if(nombre < 1 || nombre > 4){
            return false;
        }
        return true;
    }

    public static boolean isNrCarteValide(int nombre){
        return nombre >= 1 && nombre <= 4;
    }

    public static boolean isGagnante(BingoCard card){
        int sommeLigne = 0;
        int sommeColonne = 0;
        int sommeDiagonalegaoche = 0;
        int sommeDiagonaleDroite = 0;
        int[][] tableau = card.getCard();

        for(int n = 0, x = 4; n < 5; n++, x--){
            for(int m = 0; m < 5; m++){
                sommeLigne += tableau[n][m];
                sommeColonne += tableau[m][n];
            }

            sommeDiagonalegaoche += tableau[n][n];
            sommeDiagonaleDroite += tableau[n][x];

            if(sommeLigne == 0 || sommeColonne == 0){
                System.out.println("A gagné la carte nr: " + card.getNumeroCard());
                System.out.println("True");
                System.out.println("Break");
                return true;
            }
            sommeLigne = 0;
            sommeColonne = 0;
        }
        return (sommeDiagonaleDroite == 0 || sommeDiagonalegaoche == 0);



    }
}

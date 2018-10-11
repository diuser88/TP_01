package prog.objet.projet.bingo;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

public class BingoCard {
    private int colonne;
    private int ligne;

    @Getter
    private int numeroCard;

    @Getter
    protected int[][] card;


    public BingoCard(int numeroCard) {
        this.numeroCard = numeroCard;
        this.colonne = 5;
        this.ligne = 5;
        this.card = new int[this.colonne][this.ligne];

        this.card[0] = ThreadLocalRandom.current().ints(1, 16)
                        .distinct().limit(5).toArray();
        this.card[1] = ThreadLocalRandom.current().ints(16, 31)
                        .distinct().limit(5).toArray();
        this.card[2] = ThreadLocalRandom.current().ints(31, 46)
                .distinct().limit(5).toArray();
        this.card[2][2] = 0;
        this.card[3] = ThreadLocalRandom.current().ints(46, 61)
                .distinct().limit(5).toArray();
        this.card[4] = ThreadLocalRandom.current().ints(61, 76)
                .distinct().limit(5).toArray();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("| B  | I  |  N |  G | O  |\n");
        for (int l = 0; l < 26; l++)
            str.append("-");

        str.append("\n");
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                if (this.card[j][i] < 10) {
                    str.append("|  ");
                    str.append(this.card[j][i]);
                    str.append(" ");
                } else {
                    str.append("| ");
                    str.append(this.card[j][i]);
                    str.append(" ");
                }
            }
            str.append("|\n");
        }
        for (int l = 0; l < 26; l++)
            str.append("-");
        return str.toString();
    }

    public void enterBallInCard(BingoBall ball){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(this.card[i][j] == ball.getNumero().getNumero()){
                    this.card[i][j] = 0;
                }
            }
        }
    }
}

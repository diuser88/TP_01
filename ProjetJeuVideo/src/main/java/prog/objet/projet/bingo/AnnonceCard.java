package prog.objet.projet.bingo;


import java.util.*;

public class AnnonceCard implements IBingoGameSet<BingoBall>{
    private int colonne;
    private int ligne;

    private LinkedList[] card;



    public AnnonceCard(){
        this.colonne = 5;
        this.ligne = 15;
        this.card = new LinkedList[5];
        for(int i = 0; i < this.colonne; i++){
            this.card[i] = new LinkedList();
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("| B  | I  |  N |  G | O  |\n");
        for (int l = 0; l < 26; l++)
            str.append("-");

        str.append("\n");
        for(int i = 0; i < this.ligne; i++){
            for(int j = 0; j < this.colonne; j++){
                if(i >= this.card[j].size()){
                    str.append("|  ");
                    str.append(0);
                    str.append(" ");
                }else{
                    BingoBall sortie = (BingoBall) this.card[j].get(i);
                    if(sortie.getNumero().getNumero() < 10){
                        str.append("|  ");
                        str.append(this.card[j].get(i));
                        str.append(" ");
                    }
                    else{
                        str.append("| ");
                        str.append(this.card[j].get(i));
                        str.append(" ");
                    }
                }
            }
            str.append("|\n");
        }
        for (int l = 0; l < 26; l++)
            str.append("-");
        return str.toString();
    }


    @Override
    public void add(BingoBall ball) {
        switch (ball.getCouleur()){
            case BLEU:
                this.card[0].addFirst(ball);
                Collections.sort(this.card[0]);
                break;
            case ROUGE:
                this.card[1].addFirst(ball);
                Collections.sort(this.card[1]);
                break;
            case BLANC:
                this.card[2].addFirst(ball);
                Collections.sort(this.card[2]);
                break;
            case VERT:
                this.card[3].addFirst(ball);
                Collections.sort(this.card[3]);
                break;
            case JAUNE:
                this.card[4].addFirst(ball);
                Collections.sort(this.card[4]);
        }
    }

    @Override
    public BingoBall remove() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        for (LinkedList liste: this.card
             ) {
            if(liste.size() > 0) return false;
        }
        return true;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (LinkedList liste: this.card
             ) {
            size += liste.size();
        }
        return size;
    }

    @Override
    public void clearBoard() {
        for (LinkedList liste: this.card
             ) {
            liste.clear();
        }
    }
}

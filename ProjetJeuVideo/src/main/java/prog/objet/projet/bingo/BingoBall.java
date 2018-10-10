package prog.objet.projet.bingo;



import lombok.Getter;
import lombok.Setter;

public class BingoBall implements Comparable<BingoBall>{

    @Getter
    @Setter
    private Number numero;

    @Getter
    @Setter
    private Couleur couleur;


    public BingoBall(int numero){
        this.numero = new Number(numero);
        if(this.numero.getNumero() >= 1 && this.numero.getNumero() <= 15){
            this.couleur = Couleur.BLEU;
        }
        else if(this.numero.getNumero() >= 16 && this.numero.getNumero() <= 30){
            this.couleur = Couleur.ROUGE;
        }
        else if(this.numero.getNumero() >= 31 && this.numero.getNumero() <= 45){
            this.couleur = Couleur.BLANC;
        }
        else if(this.numero.getNumero() >= 46 && this.numero.getNumero() <= 60){
            this.couleur = Couleur.VERT;
        }
        else
            this.couleur = Couleur.JAUNE;
    }

    @Override
    public String toString() {
        return this.numero.toString();
    }


    @Override
    public int compareTo(BingoBall ball) {
        return this.numero.getNumero().compareTo(ball.getNumero().getNumero());
    }
}

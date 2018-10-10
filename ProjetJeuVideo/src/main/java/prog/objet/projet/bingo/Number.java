package prog.objet.projet.bingo;

import lombok.Getter;
import lombok.Setter;

import java.security.PublicKey;

public class Number {

    @Getter @Setter
    private Integer numero;

    public Number(){
        this.numero = 0;
    }

    public Number(int numero){
        this.numero = numero;
    }

    @Override
    public String toString(){
        return this.numero.toString();
    }
}

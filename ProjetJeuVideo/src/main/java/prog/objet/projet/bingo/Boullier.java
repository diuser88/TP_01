package prog.objet.projet.bingo;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boullier implements IBingoGameSet<BingoBall>{

    @Getter
    private List<BingoBall> boite;
    private final int taillemax = 75;

    public Boullier(){
        this.boite = new ArrayList<BingoBall>();
    }

    @Override
    public void add(BingoBall ball) {
        this.boite.add(ball);
    }

    @Override
    public BingoBall remove() {
        if(!this.isEmpty()){
            Random rand = new Random();
            BingoBall ball = this.boite.get(rand.nextInt(this.getSize()));
            this.boite.remove(ball);
            return ball;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if(this.boite.size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.boite.size();
    }

    @Override
    public void clearBoard() {
        this.boite.clear();
        for (int i = 1; i <= this.taillemax; i++){
            this.boite.add(new BingoBall(i));
        }
    }


}

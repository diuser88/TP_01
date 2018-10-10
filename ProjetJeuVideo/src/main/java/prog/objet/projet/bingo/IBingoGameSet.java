package prog.objet.projet.bingo;

public interface IBingoGameSet<BingoBall> {

    public abstract void add(BingoBall element);

    public abstract BingoBall remove();

    public abstract boolean isEmpty();

    public abstract int getSize();

    public abstract void clearBoard();

}

public abstract class CardGame {

    private Deck deck;

    public abstract void playGame();
    public abstract void playTurn();
    public abstract int getCardValue();
    public abstract void win();
    public abstract void lose();

}

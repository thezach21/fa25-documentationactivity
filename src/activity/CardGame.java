package activity;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class CardGame {

    protected final Deck deck;

    public CardGame() {
        this.deck = new Deck();
    }

    public abstract void playGame();

    public abstract int getCardValue(Card card);

    public abstract void win();

    public abstract void lose();

    public int getTotalValue(ArrayList<Card> cards) {
        int result = 0;
        for (Card c : cards) {
            result += getCardValue(c);
        }
        return result;
    }

    protected void reportScores(int playerScore, int dealerScore) {
        System.out.println("Player score: " + playerScore);
        System.out.println("Dealer score: " + dealerScore);
    }
    protected void reportGameOverState(boolean playerWin, int playerScore, int dealerScore) {
        if (playerWin) {
            System.out.println("You win! :)");
        } else {
            System.out.println("You lose! :(");
        }
        System.out.println("Player score: " + playerScore);
        System.out.println("Dealer score: " + dealerScore);
    }

    public boolean askPlayer(String message) {
        System.out.println(message + " (y/n)");
        Scanner s = new Scanner(System.in);
        while(true) {
            String input = s.nextLine();
            switch (input) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Invalid input. Please enter \"y\" or \"n\".");
            }
        }
    }
}

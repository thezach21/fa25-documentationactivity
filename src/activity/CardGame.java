package activity;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class defines a template for a card game. It includes several abstract methods
 * for the different basic functions of a game, as well as a few helper methods that
 * handle taking input from and printing to the terminal to make games playable.<p>
 *     These games are single player, with the player playing against an automated
 *     "dealer".
 * </p>
 */
public abstract class CardGame {

    /**
     * The {@link Deck} of cards that should be used by the game.
     */
    protected Deck deck;

    /**
     * A simple constructor that creates a {@code CardGame} object with a new {@link Deck} of cards.
     */
    public CardGame() {
        this.deck = new Deck();
    }

    /**
     * This method is called to run the game. This should include all the functionality to
     * play a single "round" of the game according to that game's rules, from starting to
     * when either {@code win()} or {@code lose()} are called.
     */
    public abstract void playGame();

    /**
     * Calculated the value of a {@link Card} according to the rules of the game.
     * @param card the {@link Card} to find the value of.
     * @return the value of the given {@link Card} as defined by the rules of the game.
     */
    public abstract int getCardValue(Card card);

    /**
     * Ends the game with a player win. This should be called when the player wins
     * according to the rules of the game.
     */
    public abstract void win();

    /**
     * Ends the game with a player loss. This should be called when the player loses
     * according to the rules of the game.
     */
    public abstract void lose();

    /**
     * Replaces the game's current deck of cards with a new one.
     */
    public void replaceDeck() {
        this.deck = new Deck();
    }

    /**
     * Calculated the total value of an {@link ArrayList} of {@link Card} objects
     * according to the behavior defined in {@code getCardValue}.
     * @param cards the list of {@link Card} objects to find the total value of
     * @return the total value of all the {@link Card} objects in the list
     */
    public int getTotalValue(ArrayList<Card> cards) {
        int result = 0;
        for (Card c : cards) {
            result += getCardValue(c);
        }
        return result;
    }

    /**
     * Prints to {@code System.out} the respective scores of the player and dealer.
     * @param playerScore the current score of the player
     * @param dealerScore the current score of the dealer
     */
    protected void reportScores(int playerScore, int dealerScore) {
        System.out.println("Player score: " + playerScore);
        System.out.println("Dealer score: " + dealerScore);
    }

    /**
     * Prints to {@code System.out} the result of the game (whether the player won or lost)
     * and the respective scores of the player and dealer.
     * @param playerWin a {@code boolean} representing whether the player won or lost
     * @param playerScore the final score of the player
     * @param dealerScore the final score of the dealer
     */
    protected void reportGameOverState(boolean playerWin, int playerScore, int dealerScore) {
        if (playerWin) {
            System.out.println("You win! :)");
        } else {
            System.out.println("You lose! :(");
        }
        reportScores(playerScore,dealerScore);
    }

    /**
     * Prompts the player with the given message, then takes yes or no input from the player
     * and returns the result. While input is being taken, the player must type their
     * response and press enter. If the player inputs anything other than 'y' for yes or 'n'
     * for no, they are prompted again.
     * @param message the message to be printed to {@code System.in} to prompt the player with a yes or no question.
     * @return the player's yes or no answer as a {@code boolean}.
     */
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
                    System.out.println(message + " (y/n)");
            }
        }
    }
}

package activity;

import java.util.ArrayList;

/**
 * An implementation of {@link CardGame} that simulates a simplified game of Blackjack.
 * {@code blackjack_rules.txt} should be consulted to see the rules of the game that are
 * adhered to in the implementation of this class.
 * @implNote This game does not include any betting. CSE116 does not endorse gambling!
 */
public class Blackjack extends CardGame {

    private final ArrayList<Card> playerHand;
    private final ArrayList<Card> dealerHand;

    /**
     * A constructor that initializes the player and dealer's hands.
     */
    public Blackjack() {
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }

    /**
     * Executes the functionality of the player's turn in Blackjack.
     */
    private void playerTurn() {
        while (getTotalValue(playerHand) < 21 && getTotalValue(dealerHand) < 21) {
            reportScores(getTotalValue(playerHand),getTotalValue(dealerHand));
            if (askPlayer("Draw another card?")) {
                playerHand.add(this.deck.drawCard());
            } else {
                return;
            }
        }
    }

    /**
     * Executes the functionality of the dealer's turn in Blackjack.
     */
    private void dealerTurn() {
        while (getTotalValue(dealerHand) < 16) {
            dealerHand.add(this.deck.drawCard());
        }
    }

    /**
     * Checks the values of the player and dealer's hands to determine the winner of the round.
     * @return {@code true} if the player wins, {@code false} otherwise.
     */
    private boolean evaluateWin() {
        return (getTotalValue(playerHand) >= getTotalValue(dealerHand) || getTotalValue(dealerHand) > 21) && getTotalValue(playerHand) <= 21;
    }

    /**
     * Determines the value of a {@link Card} according to the rules
     * of Blackjack. In this case, numbered ranks (2-10) are directly
     * converted to their respective number, face cards are converted to 10,
     * and aces are converted to 11.
     * @param card the {@link Card} to find the value of.
     * @return the value of that card according to Blackjack rules.
     */
    private int cardValue(Card card) {
        return switch (card.rank()) {
            case Card.Rank.TWO -> 2;
            case Card.Rank.THREE -> 3;
            case Card.Rank.FOUR -> 4;
            case Card.Rank.FIVE -> 5;
            case Card.Rank.SIX -> 6;
            case Card.Rank.SEVEN -> 7;
            case Card.Rank.EIGHT -> 8;
            case Card.Rank.NINE -> 9;
            case Card.Rank.TEN, Card.Rank.QUEEN, Card.Rank.JACK, Card.Rank.KING -> 10;
            case Card.Rank.ACE -> 11;
        };
    }

    @Override
    public void playGame() {
        this.deck.shuffle();
        playerHand.add(this.deck.drawCard());
        playerHand.add(this.deck.drawCard());
        dealerHand.add(this.deck.drawCard());
        playerTurn();
        if (getTotalValue(playerHand) <= 21) {
            dealerTurn();
        }
        if (evaluateWin()) {
            win();
        } else {
            lose();
        }
    }

    @Override
    public int getCardValue(Card card) {
        return cardValue(card);
    }

    @Override
    public void win() {
        reportGameOverState(true,getTotalValue(playerHand),getTotalValue(dealerHand));
    }

    @Override
    public void lose() {
        reportGameOverState(false,getTotalValue(playerHand),getTotalValue(dealerHand));
    }

    //Run this to play a round of Blackjack!
    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        game.playGame();
    }
}

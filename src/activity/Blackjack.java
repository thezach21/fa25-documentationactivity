package activity;

import java.util.ArrayList;

public class Blackjack extends CardGame {

    private final ArrayList<Card> playerHand;
    private final ArrayList<Card> dealerHand;
    boolean playerTurn;

    public Blackjack() {
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }

    @Override
    public void playGame() {
        this.deck.shuffle();
        playerHand.add(this.deck.drawCard());
        playerHand.add(this.deck.drawCard());
        dealerHand.add(this.deck.drawCard());
        playerTurn = true;
        while (getTotalValue(playerHand) < 21 && getTotalValue(dealerHand) < 21) {
            reportScores(getTotalValue(playerHand),getTotalValue(dealerHand));
            if (askPlayer("Draw another card?")) {
                playerHand.add(this.deck.drawCard());
            } else {
                break;
            }
            playerTurn = !playerTurn;
        }
        while (getTotalValue(dealerHand) < 16) {
            dealerHand.add(this.deck.drawCard());
        }
        if ((getTotalValue(playerHand) >= getTotalValue(dealerHand) || getTotalValue(dealerHand) > 21) && getTotalValue(playerHand) <= 21) {
            win();
        } else {
            lose();
        }
    }

    @Override
    public int getCardValue(Card card) {
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
    public void win() {
        reportGameOverState(true,getTotalValue(playerHand),getTotalValue(dealerHand));
    }

    @Override
    public void lose() {
        reportGameOverState(false,getTotalValue(playerHand),getTotalValue(dealerHand));
    }
}

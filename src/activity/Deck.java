package activity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class representing a deck of cards, which are themselves represented with {@link Card} objects.
 */
public class Deck {

    /**
     * The {@link Card} objects stored in this deck.
     * @implNote The last element of this list is considered the "top" of the deck.
     */
    private ArrayList<Card> cards;

    /**
     * Constructs a new {@code Deck} as a standard 52-card deck of playing cards.
     * @implNote this method does not shuffle the created deck and will create the same
     * deck ordering every time it is called.
     */
    public Deck() {
        this.populateDeck();
    }

    /**
     * Replaces the current contents of the deck with a new standard 52-card
     * deck of playing cards.
     * @implNote this method does not shuffle the created deck and will create the same
     * deck ordering every time it is called.
     */
    public void populateDeck() {
        this.cards = new ArrayList<>();
        for (Card.Rank rank : Card.Rank.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cards.add(new Card(rank,suit));
            }
        }
    }

    /**
     * Shuffles the deck, putting its cards into a random order.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Removes and returns the top card of the deck.
     * @return the removed top card of the deck
     */
    public Card drawCard() {
        return cards.removeLast();
    }
}

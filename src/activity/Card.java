package activity;

/**
 * A representation of a standard playing card.
 * @implNote This is a record! You probably have not seen one of these before, but do not worry!
 * You do not actually have to use this class in order to get a working solution. If you are curious though,
 * it works very similarly to a barebones class. Objects of a record class are created using a constructor in the same
 * way that normal classes are, where the parameters of that constructor are seen in the parentheses in the class header line and
 * the constructor just sets instance variables of the same name as the parameters. These instance variables are treated as private
 * final variables that can be accessed with a getter that has the same name as the variables, so in this case you would access
 * the rank of a Card object named card1 by calling card1.rank().
 * <p>
 *     This class also includes two internal enums! These are special data types that represent groups of possible constant values.
 *     In this case, they define all the possible ranks and suits of a playing card. This is nice because it ensures that there
 *     can never be a card object with its suit instance variable set to anything other than the four card suits, for example. It
 *     also makes it possible to iterate over all possible values of a certain type! See the {@code populateDeck()} method of the
 *     {@link Deck} class to see an example of this.
 * </p>
 *
 * @param rank the rank of the card
 * @param suit the suit of the card
 */
public record Card(Rank rank, Suit suit) {

    /**
     * A type defining the different suits of a playing card.
     * @implNote The suit of a card is not actually considered in this activity,
     * but if a different card game were to be made in this project this
     * would potentially come in handy!
     */
    public enum Suit {
        HEARTS,
        SPADES,
        DIAMONDS,
        CLUBS
    }

    /**
     * A type defining the possible ranks of a playing card.
     */
    public enum Rank {
        TWO,
        THREE,
        FOUR,
        FIVE,

        SIX,
        SEVEN,

        EIGHT,
        NINE,
        TEN,
        JACK, // like the TA
        QUEEN,
        KING,
        ACE
    }
}

public record Card(Rank rank,Suit suit) {
    public enum Suit {
        HEARTS,
        SPADES,
        DIAMONDS,
        CLUBS
    }
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

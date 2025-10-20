# Lab Activity 2 — Documentation
Your goal in this activity is to implement a child class of a preexisting
class by reading documentation and specification to know what given methods
to use and how to use them. The code you need to write to get the game working
should be simple, as most of the work is done for you, but it would be tricky
to figure out how the given code works and how you need to use it. Thankfully,
all the given code as well as the rules for what you have to write are clearly
documented and laid out for you, so by reading through everything you should
be able to get it working despite not fully understanding the code. That is
the main purpose of this activity — demonstrating that if code is well
documented, you don't actually need to know how it works to use it!

In addition to this activity demonstrating the usefulness of documentation,
it should also serve as an example of using inheritance (the topic of today's
quiz!) to easily expand on existing code. Since all of your code will be written
in `Blackjack.java`, a child class of `CardGame.java`, you will be adding
functionality onto the `CardGame` class without needing to write the entire
thing. Theoretically, you could then extend that same `CardGame` class to make
all sorts of games without needing to rewrite the base functionality!

### Beginning the Activity
You will be writing in the `Blackjack.java` class to make it extend `CardGame.java`
and implement all of its methods. Currently, the class only has a few helper
methods provided to make your work a bit easier and faster. Your first step
should be to make it extend its parent class (because right now there is not
actually any inheritance going on), and from there you should look to see
what methods you need to override and what those methods should do. Most of
the methods you need to use are contained in either `Blackjack.java` or
`CardGame.java`, but you will also need to look at the methods in `Deck.java`.
You should try to read through everything and try to figure it out, but if you are having
some trouble feel free to reference the hints provided below.

When you get it working, try writing some Javadoc comments of your own on the
methods you wrote!

### Hints
1. You may not use all the provided methods but the provided methods should
be doing most of the work for you. Always think carefully about what you need
to do, and check if there is a method that can help you with it.
2. `getCardValue`, `win`, and `lose` can each be completed in a single line by
calling a method provided for you somewhere in either `Blackjack.java` or
`CardGame.java`.
3. Reading `blackjack_rules.txt` should help you understand what steps
need to be taken to make the game work as it should. If your `playGame` method
performs the steps in "GAME START & PLAYER TURN" followed by "DEALER TURN",
then decides the winner according to "WINNING & LOSING", your game should
work as intended.
4. If you are still having trouble thinking of how to go about making `playGame`,
follow these steps:
   1. Shuffle the deck, since according to `Deck.java`'s constructor the deck
   does not get shuffled automatically
   2. Have the player and dealer draw cards into their respective hands, the
    amount of cards to draw for each is outlined in the rules
   3. Begin the player's turn (The code for the player turn is provided for you)
   4. If the game has not already ended after the player turn, begin the dealer's
    turn (Code for the dealer's turn is also provided)
   5. Evaluate the winner, and call the `win` or `lose` method accordingly.
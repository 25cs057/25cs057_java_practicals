package exercise2;

/**
 * Practical 03 - Exercise 2 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * (d) In Driver.main: add cards to a Card[] one at a time; before adding each,
 *     use equals() to check it against the earlier cards.
 * (e) Print "Duplicate found: <card>" the first time a repeat appears.
 * Expected output: a second "Ace of Spades" -> "Duplicate found: Ace of Spades".
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 03 - Exercise 2: Duplicate Card Check ===");

        // Stream of cards to insert one by one
        Card[] incomingCards = new Card[] {
            new Card("King", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("10", "Hearts"),
            new Card("Ace", "Spades"), // Duplicate of earlier card
            new Card("Jack", "Clubs")
        };

        // Storage array for accepted unique cards
        Card[] cardDeck = new Card[incomingCards.length];
        int count = 0;
        boolean duplicateAlerted = false;

        System.out.println("Inserting cards into deck one by one:");
        for (Card nextCard : incomingCards) {
            boolean duplicate = false;

            // (d) Before adding, check against earlier cards using equals()
            for (int i = 0; i < count; i++) {
                if (nextCard.equals(cardDeck[i])) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                // (e) Print duplicate message on first repeat
                System.out.println("Duplicate found: " + nextCard);
                duplicateAlerted = true;
            } else {
                cardDeck[count++] = nextCard;
                System.out.println("Added: " + nextCard + " (Deck size: " + count + ")");
            }
        }

        System.out.println("\n--- Final Deck Status ---");
        System.out.println("Total unique cards stored: " + count);
        for (int i = 0; i < count; i++) {
            System.out.println("  " + (i + 1) + ". " + cardDeck[i]);
        }
    }
}


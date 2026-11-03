package exercise2;

import java.util.Objects;

/**
 * Practical 03 - Exercise 2
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * (a) Create class Card with private String rank, suit and a constructor.
 * (b) Override toString() to return rank + " of " + suit (e.g. "Queen of Hearts").
 * (c) Override equals()/hashCode() by rank + suit.
 */
public class Card {
    // (a) Private fields
    private final String rank;
    private final String suit;

    // Constructor
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    // (b) Override toString() to return rank + " of " + suit
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // (c) Override equals() by rank and suit (case-insensitive for robust comparison)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        return Objects.equals(this.rank, other.rank) &&
               Objects.equals(this.suit, other.suit);
    }

    // Override hashCode() based on rank and suit
    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}


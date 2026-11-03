/**
 * Practical 01 - Exercise 1
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * 1. Vending machine (VendingMachine.java, main in this file)
 * (a) Define an enum Coin with constants ONE, TWO, FIVE, TEN.
 * (b) In main, set a snack price of 15 and a running total of 0; create a Scanner.
 * (c) Loop: read a coin name, use a switch expression to convert the Coin to its value
 *     (ONE->1, TWO->2, FIVE->5, TEN->10), add it to the total, and print the total so far.
 * (d) Stop the loop once the total reaches 15 or more.
 * (e) Print the change to return (total - 15).
 * Expected output: TEN then FIVE prints "Paid. Change: 0"; TEN then TEN prints "Paid. Change: 5".
 */

import java.util.Scanner;

// (a) Define an enum Coin with constants ONE, TWO, FIVE, TEN
enum Coin {
    ONE,
    TWO,
    FIVE,
    TEN
}

public class VendingMachine {
    public static void main(String[] args) {
        // (b) In main, set a snack price of 15 and a running total of 0; create a Scanner
        final int SNACK_PRICE = 15;
        int total = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Vending Machine ===");
        System.out.println("Snack Price: " + SNACK_PRICE);
        System.out.println("Accepted Coins: ONE, TWO, FIVE, TEN");

        // (c) Loop: read a coin name, use a switch expression to convert Coin to its value,
        // add to total, and print total so far.
        // (d) Stop the loop once the total reaches 15 or more.
        while (total < SNACK_PRICE) {
            System.out.print("Insert coin (ONE, TWO, FIVE, TEN): ");
            String input = scanner.next().trim().toUpperCase();

            Coin coin;
            try {
                coin = Coin.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid coin: " + input + ". Please insert a valid coin.");
                continue;
            }

            // Java switch expression converting Coin to its monetary value
            int coinValue = switch (coin) {
                case ONE -> 1;
                case TWO -> 2;
                case FIVE -> 5;
                case TEN -> 10;
            };

            total += coinValue;
            System.out.println("Coin inserted: " + coin + " (" + coinValue + "). Total so far: " + total);
        }

        // (e) Print the change to return (total - 15)
        int change = total - SNACK_PRICE;
        System.out.println("Paid. Change: " + change);

        scanner.close();
    }
}


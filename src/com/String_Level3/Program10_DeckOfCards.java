package com.String_Level3;

import java.util.Scanner;

public class Program10_DeckOfCards {

    public static String[] createDeck() {

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "Jack", "Queen", "King", "Ace"
        };

        String[] deck = new String[52];

        int index = 0;

        for (int i = 0; i < suits.length; i++) {

            for (int j = 0; j < ranks.length; j++) {

                deck[index] = ranks[j] + " of " + suits[i];

                index++;
            }
        }

        return deck;
    }

    public static void shuffleDeck(String[] deck) {

        for (int i = 0; i < deck.length; i++) {

            int randomIndex = (int) (Math.random() * deck.length);

            String temp = deck[i];

            deck[i] = deck[randomIndex];

            deck[randomIndex] = temp;
        }
    }

    public static void distributeCards(String[] deck, int n, int players) {

        if (players <= 0 || n > deck.length || n < 0 || n % players != 0) {

            System.out.println("Cards cannot be distributed equally.");
            return;
        }

        int cardsPerPlayer = n / players;

        int index = 0;

        for (int i = 0; i < players; i++) {

            System.out.println("\nPlayer " + (i + 1) + " cards:");

            for (int j = 0; j < cardsPerPlayer; j++) {

                System.out.println(deck[index]);

                index++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] deck = createDeck();

        shuffleDeck(deck);

        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        distributeCards(deck, n, players);

        sc.close();
    }
}
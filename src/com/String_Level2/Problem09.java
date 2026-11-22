package com.String_Level2;
import java.util.Scanner;
public class Problem09 {

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) {
            return "Rock";
        }
        else if (choice == 1) {
            return "Paper";
        }

        return "Scissors";
    }
    public static String findWinner(String player, String computer) {

        if (player.equals(computer)) {
            return "Draw";
        }
        if ((player.equals("Rock") && computer.equals("Scissors"))
                || (player.equals("Paper") && computer.equals("Rock"))
                || (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player";
        }

        return "Computer";
    }

    public static String[][] calculateStats(int playerWins,
                                            int computerWins,
                                            int draws,
                                            int totalGames) {

        String[][] stats = new String[3][3];

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.valueOf(playerWins * 100.0 / totalGames);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf(computerWins * 100.0 / totalGames);

        stats[2][0] = "Draws";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = String.valueOf(draws * 100.0 / totalGames);

        return stats;
    }

    public static void displayResults(String[][] games, String[][] stats) {

        System.out.println("\nGame\tPlayer\t\tComputer\tWinner");

        for (int i = 0; i < games.length; i++) {
            System.out.println(
                    (i + 1) + "\t"
                            + games[i][0] + "\t\t"
                            + games[i][1] + "\t\t"
                            + games[i][2]);
        }

        System.out.println("\nResult\t\tWin Percentage");

        for (int i = 0; i < stats.length; i++) {
            System.out.printf(
                    "%-16s %.2f%%%n",
                    stats[i][0],
                    Double.parseDouble(stats[i][2]));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many games do you want to play? ");
        int numberOfGames = sc.nextInt();

        if (numberOfGames <= 0) {
            System.out.println("Please enter a number greater than zero.");
            sc.close();
            return;
        }

        String[][] games = new String[numberOfGames][3];

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < numberOfGames; i++) {

            System.out.print(
                    "Game " + (i + 1)
                            + " - Enter Rock, Paper, or Scissors: ");

            String player = sc.next().toLowerCase();

            while (!player.equals("rock")
                    && !player.equals("paper")
                    && !player.equals("scissors")) {

                System.out.print(
                        "Invalid choice. Enter Rock, Paper, or Scissors: ");

                player = sc.next().toLowerCase();
            }

            if (player.equals("rock")) {
                player = "Rock";
            }
            else if (player.equals("paper")) {
                player = "Paper";
            }
            else {
                player = "Scissors";
            }

            String computer = getComputerChoice();
            String winner = findWinner(player, computer);

            if (winner.equals("Player")) {
                playerWins++;
            }
            else if (winner.equals("Computer")) {
                computerWins++;
            }
            else {
                draws++;
            }

            games[i][0] = player;
            games[i][1] = computer;
            games[i][2] = winner;
        }

        String[][] stats =
                calculateStats(playerWins,
                        computerWins,
                        draws,
                        numberOfGames);

        displayResults(games, stats);

        sc.close();
    }
}
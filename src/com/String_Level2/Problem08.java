package com.String_Level2;

import java.util.Scanner;

public class Problem08 {

    public static int[] generateAges(int numberOfStudents) {

        int[] ages = new int[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            ages[i] = (int) (Math.random() * 90) + 10;
        }

        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            result[i][0] = ages[i] + "";

            if (ages[i] < 0) {
                result[i][1] = "Invalid Age";
            }
            else if (ages[i] >= 18) {
                result[i][1] = "Can Vote";
            }
            else {
                result[i][1] = "Cannot Vote";
            }
        }

        return result;
    }

    public static void displayTable(String[][] result) {

        System.out.println("\nStudent\tAge\tVoting Status");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                    (i + 1) + "\t"
                            + result[i][0] + "\t"
                            + result[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        if (numberOfStudents <= 0) {
            System.out.println("Number of students must be greater than zero.");
        }
        else {

            int[] ages = generateAges(numberOfStudents);

            String[][] result = checkVotingEligibility(ages);

            displayTable(result);
        }

        sc.close();
    }
}

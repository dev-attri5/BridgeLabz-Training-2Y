package com.String_Level2;

import java.util.Scanner;

public class Problem10 {

    public static int[][] generateMarks(int numberOfStudents) {

        int[][] marks = new int[numberOfStudents][3];

        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = (int) (Math.random() * 100);
            }
        }

        return marks;
    }

    public static double[][] calculateResults(int[][] marks) {

        double[][] results = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = total * 100.0 / 300;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return results;
    }

    public static String[][] calculateGrades(double[][] results) {

        String[][] grades = new String[results.length][1];

        for (int i = 0; i < results.length; i++) {

            double percentage = results[i][2];

            if (percentage >= 80) {
                grades[i][0] = "A";
            }
            else if (percentage >= 70) {
                grades[i][0] = "B";
            }
            else if (percentage >= 60) {
                grades[i][0] = "C";
            }
            else if (percentage >= 50) {
                grades[i][0] = "D";
            }
            else if (percentage >= 40) {
                grades[i][0] = "E";
            }
            else {
                grades[i][0] = "R";
            }
        }

        return grades;
    }

    public static void displayScorecard(
            int[][] marks,
            double[][] results,
            String[][] grades) {

        System.out.println(
                "\nStudent\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");

        for (int i = 0; i < marks.length; i++) {

            System.out.printf(
                    "%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f%%\t\t%s%n",
                    (i + 1),
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    results[i][0],
                    results[i][1],
                    results[i][2],
                    grades[i][0]);
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

            int[][] marks = generateMarks(numberOfStudents);

            double[][] results = calculateResults(marks);

            String[][] grades = calculateGrades(results);

            displayScorecard(marks, results, grades);
        }

        sc.close();
    }
}
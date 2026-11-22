package com.String_Level3;

import java.util.Scanner;

public class Program1 {

    public static double calculateBMI(double weight, double height) {
        double heightMeter = height / 100;
        double bmi = weight / (heightMeter * heightMeter);

        return bmi;
    }

    public static String findStatus(double bmi) {

        if (bmi <= 18.4) {
            return "Underweight";
        }
        else if (bmi <= 24.9) {
            return "Normal";
        }
        else if (bmi <= 39.9) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    public static void displayTable(double[][] data) {

        System.out.println("\nPerson\tHeight\tWeight\tBMI\tStatus");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < 10; i++) {

            double weight = data[i][0];
            double height = data[i][1];

            double bmi = calculateBMI(weight, height);

            bmi = Math.round(bmi * 100) / 100.0;

            String status = findStatus(bmi);

            System.out.println((i + 1) + "\t" + height + "\t"
                    + weight + "\t" + bmi + "\t" + status);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] teamData = new double[10][2];

        for (int i = 0; i < 10; i++) {

            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Enter weight in kg: ");
            teamData[i][0] = sc.nextDouble();

            System.out.print("Enter height in cm: ");
            teamData[i][1] = sc.nextDouble();
        }

        displayTable(teamData);

        sc.close();
    }
}
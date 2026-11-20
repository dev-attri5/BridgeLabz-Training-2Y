package Level2_Arrays_assignment;

import java.util.Scanner;

public class Problem06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Person " + (i + 1));

            System.out.print("Enter Weight (kg): ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter Height (m): ");
            height[i] = sc.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);
        }

        System.out.println("\nWeight\tHeight\tBMI");

        for (int i = 0; i < n; i++) {
            System.out.println(weight[i] + "\t" +
                    height[i] + "\t" +
                    bmi[i]);
        }

        sc.close();
    }
}
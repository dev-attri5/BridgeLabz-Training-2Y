package Level2_Arrays_assignment;

import java.util.Scanner;

public class Problem07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3];

        for (int i = 0; i < n; i++) {

            System.out.println("Person " + (i + 1));

            System.out.print("Enter Weight (kg): ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Enter Height (m): ");
            personData[i][1] = sc.nextDouble();

            personData[i][2] = personData[i][0] /
                    (personData[i][1] * personData[i][1]);
        }

        System.out.println("\nWeight\tHeight\tBMI");

        for (int i = 0; i < n; i++) {
            System.out.println(
                    personData[i][0] + "\t" +
                            personData[i][1] + "\t" +
                            personData[i][2]
            );
        }

        sc.close();
    }
}
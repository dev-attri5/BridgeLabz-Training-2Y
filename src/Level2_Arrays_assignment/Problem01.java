package Level2_Arrays_assignment;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];

        for (int i = 0; i < 10; i++) {

            System.out.println("Employee " + (i + 1));

            System.out.print("Enter Salary: ");
            salary[i] = sc.nextDouble();

            System.out.print("Enter Years of Service: ");
            years[i] = sc.nextDouble();

            if (years[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }
        }

        System.out.println("\nEmployee Details");

        for (int i = 0; i < 10; i++) {
            System.out.println(
                    "Employee " + (i + 1) +
                            " Salary = " + salary[i] +
                            " Bonus = " + bonus[i]
            );
        }

        sc.close();
    }
}
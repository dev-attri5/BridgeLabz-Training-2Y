package Level2_Arrays_assignment;

import java.util.Scanner;

public class Problem09 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percentage = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Student " + (i + 1));

            System.out.print("Enter Physics Marks: ");
            marks[i][0] = sc.nextInt();

            System.out.print("Enter Chemistry Marks: ");
            marks[i][1] = sc.nextInt();

            System.out.print("Enter Maths Marks: ");
            marks[i][2] = sc.nextInt();

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;
        }

        System.out.println("\nPhy\tChem\tMath\tPercentage");

        for (int i = 0; i < n; i++) {
            System.out.println(
                    marks[i][0] + "\t" +
                            marks[i][1] + "\t" +
                            marks[i][2] + "\t" +
                            percentage[i]
            );
        }

        sc.close();
    }
}
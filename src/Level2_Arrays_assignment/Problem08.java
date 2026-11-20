package Level2_Arrays_assignment;

import java.util.Scanner;

public class Problem08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Student " + (i + 1));

            System.out.print("Enter Physics Marks: ");
            physics[i] = sc.nextInt();

            System.out.print("Enter Chemistry Marks: ");
            chemistry[i] = sc.nextInt();

            System.out.print("Enter Maths Marks: ");
            maths[i] = sc.nextInt();

            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;
        }

        System.out.println("\nPhy\tChem\tMath\tPercentage");

        for (int i = 0; i < n; i++) {
            System.out.println(
                    physics[i] + "\t" +
                            chemistry[i] + "\t" +
                            maths[i] + "\t" +
                            percentage[i]
            );
        }

        sc.close();
    }
}

package Level2_Arrays_assignment;

import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {

            System.out.println("Enter details for " + names[i]);

            System.out.print("Enter Age: ");
            ages[i] = sc.nextInt();

            System.out.print("Enter Height: ");
            heights[i] = sc.nextDouble();
        }

        int youngest = 0;
        int tallest = 0;

        for (int i = 1; i < 3; i++) {

            if (ages[i] < ages[youngest]) {
                youngest = i;
            }

            if (heights[i] > heights[tallest]) {
                tallest = i;
            }
        }

        System.out.println("\nYoungest Friend: " + names[youngest]);
        System.out.println("Age: " + ages[youngest]);

        System.out.println("\nTallest Friend: " + names[tallest]);
        System.out.println("Height: " + heights[tallest]);

        sc.close();
    }
}
package Level1_Arrays_assignment;

import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] results = new int[10];

        for (int i = 1; i <= 10; i++) {
            results[i - 1] = number * i;
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + results[i - 1]);
        }

        sc.close();
    }
}

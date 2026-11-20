package Level2_Arrays_assignment;

import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] frequency = new int[10];

        while (number > 0) {
            int digit = number % 10;
            frequency[digit]++;
            number = number / 10;
        }

        System.out.println("Digit Frequency:");

        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + " = " + frequency[i]);
            }
        }

        sc.close();
    }
}
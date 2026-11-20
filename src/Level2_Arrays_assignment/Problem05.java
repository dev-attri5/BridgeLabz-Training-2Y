package Level2_Arrays_assignment;

import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = new int[10];
        int count = 0;

        while (number > 0) {
            digits[count] = number % 10;
            number = number / 10;
            count++;
        }

        System.out.print("Reversed Number: ");

        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }

        sc.close();
    }
}
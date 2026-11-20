package Level2_Arrays_assignment;

import java.util.Scanner;

public class Problem03 {
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

        int largest = digits[0];
        int secondLargest = digits[0];

        for (int i = 0; i < count; i++) {

            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest Digit = " + largest);
        System.out.println("Second Largest Digit = " + secondLargest);

        sc.close();
    }
}
package com.recursion.home_work;

import java.util.Scanner;

public class CountCharacter {
    static int countCharacter(String str, char target, int index) {
        if (index == str.length()) {
            return 0;
        }
        int count;

        if (str.charAt(index) == target) {
            count = 1;
        } else {
            count = 0;
        }
        return count + countCharacter(str, target, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter the character to count: ");
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("No character entered.");
        } else {
            System.out.println("Occurrences: "
                    + countCharacter(str, input.charAt(0), 0));
        }
        sc.close();
    }
}

package com.recursion.home_work;

import java.util.Scanner;

public class RemoveCharacter {
    static String removeCharacter(String str, char target, int index) {
        if (index == str.length()) {
            return "";
        }
        char ch = str.charAt(index);
        if (ch == target) {
            return removeCharacter(str, target, index + 1);
        }
        return ch + removeCharacter(str, target, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter the character to remove: ");
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("No character entered.");
        } else {
            System.out.println("Result: "
                    + removeCharacter(str, input.charAt(0), 0));
        }
        sc.close();
    }
}

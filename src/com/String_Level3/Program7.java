package com.String_Level3;

import java.util.Scanner;

public class Program7 {

    public static boolean checkPalindrome(String text) {

        for (int i = 0; i < text.length() / 2; i++) {

            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        boolean result = checkPalindrome(text);

        if (result == true) {
            System.out.println("The given text is a Palindrome.");
        }
        else {
            System.out.println("The given text is not a Palindrome.");
        }

        sc.close();
    }
}
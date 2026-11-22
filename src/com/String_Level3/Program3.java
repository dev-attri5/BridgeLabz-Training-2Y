package com.String_Level3;

import java.util.Scanner;

public class Program3 {

    public static char findFirstNonRepeating(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch] = freq[ch] + 1;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char ans = findFirstNonRepeating(text);

        if (ans != ' ') {
            System.out.println("First non-repeating character: " + ans);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}

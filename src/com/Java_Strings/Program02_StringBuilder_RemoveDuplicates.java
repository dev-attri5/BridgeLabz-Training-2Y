package com.Java_Strings;

import java.util.HashSet;
import java.util.Scanner;

public class Program02_StringBuilder_RemoveDuplicates {

    public static String removeDuplicates(String text) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<Character>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!seen.contains(ch)) {
                sb.append(ch);
                seen.add(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String result = removeDuplicates(text);
        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}

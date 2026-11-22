package com.Java_Strings;

import java.util.Scanner;

public class Program03_StringBuffer_Concatenate {

    public static String concatenateStrings(String[] words) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] words = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        String combined = concatenateStrings(words);
        System.out.println("Concatenated string: " + combined);

        sc.close();
    }
}

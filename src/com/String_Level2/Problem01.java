package com.String_Level2;

import java.util.Scanner;

public class Problem01 {

    public static int findStringLength(String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = sc.next();

        System.out.println("Length without length(): " + findStringLength(text));

        sc.close();
    }
}
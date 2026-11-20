package com.String_Level1;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String first = sc.next();

        System.out.print("Enter second string: ");
        String second = sc.next();

        boolean same = true;

        if (first.length() != second.length()) {
            same = false;
        } else {
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    same = false;
                }
            }
        }

        System.out.println("Strings are same: " + same);

        sc.close();
    }
}
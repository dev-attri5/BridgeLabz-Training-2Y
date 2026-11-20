package com.String_Level1;

import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String sub = "";

        for (int i = start; i < end; i++) {
            sub = sub + text.charAt(i);
        }

        System.out.println("Substring: " + sub);

        sc.close();
    }
}
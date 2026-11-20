package com.String_Level1;

import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        char[] chars = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }

        System.out.println("Characters are:");

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }

        sc.close();
    }
}
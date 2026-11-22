package com.String_Level3;

import java.util.Scanner;

public class Program6 {

    public static void getCharFrequency(String text) {

        System.out.println("\nCharacter Frequencies:");

        for (int i = 0; i < text.length(); i++) {

            boolean alreadyCounted = false;

            for (int j = 0; j < i; j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (alreadyCounted == false) {

                int count = 0;

                for (int j = 0; j < text.length(); j++) {

                    if (text.charAt(i) == text.charAt(j)) {
                        count++;
                    }
                }

                System.out.println(text.charAt(i) + " - " + count);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        getCharFrequency(text);

        sc.close();
    }
}
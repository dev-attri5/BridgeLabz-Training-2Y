package com.String_Level3;

import java.util.Scanner;

public class Program2 {

    public static void findUniqueCharacters(String text) {

        System.out.print("Unique characters: ");

        for (int i = 0; i < text.length(); i++) {

            boolean isUnique = true;

            for (int j = 0; j < i; j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique == true) {
                System.out.print(text.charAt(i) + " ");
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        findUniqueCharacters(text);

        sc.close();
    }
}
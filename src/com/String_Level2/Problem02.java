package com.String_Level2;

import java.util.Scanner;

public class Problem02 {

    public static String[] splitText(String text) {

        int wordCount = 0;
        boolean isWord = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                if (!isWord) {
                    wordCount++;
                    isWord = true;
                }
            } else {
                isWord = false;
            }
        }

        String[] words = new String[wordCount];

        int index = 0;
        String word = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.equals("")) {
                    words[index] = word;
                    index++;
                    word = "";
                }
            }
        }

        if (!word.equals("")) {
            words[index] = word;
        }

        return words;
    }

    public static boolean compareArrays(String[] first, String[] second) {

        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] userWords = splitText(text);

        String[] builtInWords;
        if (text.trim().equals("")) {
            builtInWords = new String[0];
        } else {
            builtInWords = text.trim().split("\\s+");
        }

        System.out.println("\nWords using user method:");
        for (int i = 0; i < userWords.length; i++) {
            System.out.println(userWords[i]);
        }

        System.out.println("\nWords using split():");
        for (int i = 0; i < builtInWords.length; i++) {
            System.out.println(builtInWords[i]);
        }

        System.out.println("\nBoth results are same: "
                + compareArrays(userWords, builtInWords));

        sc.close();
    }
}
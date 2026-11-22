package com.String_Level2;

import java.util.Scanner;

public class Problem03 {

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

    public static String[][] createWordLengthArray(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = words[i].length() + "";
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = splitText(text);

        String[][] result = createWordLengthArray(words);

        System.out.println("\nWord\t\tLength");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }

        sc.close();
    }
}
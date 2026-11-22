package com.Java_Strings;

import java.util.Scanner;

public class Program11_LinearSearch_WordInSentences {

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].contains(word)) {
                return sentences[i];
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] sentences = new String[n];
        System.out.println("Enter sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);

        sc.close();
    }
}

package com.String_Level2;

import java.util.Scanner;

public class Problem04 {

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
            result[i][1] = String.valueOf(words[i].length());
        }

        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordData) {

        int[] indexes = {0, 0};

        if (wordData.length == 0) {
            return new int[]{-1, -1};
        }

        int shortestLength = Integer.parseInt(wordData[0][1]);
        int longestLength = Integer.parseInt(wordData[0][1]);

        for (int i = 1; i < wordData.length; i++) {

            int currentLength = Integer.parseInt(wordData[i][1]);

            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                indexes[0] = i;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                indexes[1] = i;
            }
        }

        return indexes;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = splitText(text);
        String[][] wordData = createWordLengthArray(words);

        int[] answer = findShortestAndLongest(wordData);

        if (answer[0] == -1) {
            System.out.println("No words found.");
        } else {
            System.out.println("Shortest word: " + wordData[answer[0]][0]);
            System.out.println("Longest word: " + wordData[answer[1]][0]);
        }

        sc.close();
    }
}
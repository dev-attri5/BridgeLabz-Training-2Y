package com.Strings;

import java.util.Scanner;

public class isPrefix {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        sc.nextLine();

        String[] searchWord = new String[n];

        for (int i = 0; i < n; i++) {
            searchWord[i] = sc.nextLine();
        }


        String[] sentence = new String[n];

        for (int i = 0; i < n; i++) {
            sentence[i] = sc.nextLine();
        }


    }
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {

            if (words[i].startsWith(searchWord)) {

                return i + 1;
            }
        }
        return -1;
    }
}

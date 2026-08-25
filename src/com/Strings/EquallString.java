package com.Strings;

import java.util.Scanner;

public class EquallString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        sc.nextLine();

        String[] word1 = new String[n];
        String[] word2 = new String[n];

        for (int i = 0; i < n; i++) {
            word2[i] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            word1[i] = sc.nextLine();
        }
        System.out.println( arrayStringsAreEqual(word1,word2));
    }

        public static boolean arrayStringsAreEqual (String[]word1, String[]word2){
            String s1 = String.join("", word1);

            String s2 = String.join("", word2);

            return s1.equals(s2);
        }
    }


package com.recursion.home_work;

import java.util.Scanner;

public class CountVowels {
    static int countVowels(String str, int index) {
        if (index == str.length()) {
            return 0;
        }
        char ch = Character.toLowerCase(str.charAt(index));
        int count;

        if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') {
            count = 1;
        } else {
            count = 0;
        }
        return count + countVowels(str, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Number of vowels: " + countVowels(str, 0));
        sc.close();
    }
}

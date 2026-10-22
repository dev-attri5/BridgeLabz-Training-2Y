package com.recursion.home_work;

import java.util.Scanner;

public class PrintCharacters {
    static void printCharacters(String str, int index) {
        if (index == str.length()) {
            return;
        }
        System.out.println(str.charAt(index));
        printCharacters(str, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        printCharacters(str, 0);
        sc.close();
    }
}

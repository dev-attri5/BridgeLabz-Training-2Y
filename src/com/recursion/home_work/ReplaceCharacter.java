package com.recursion.home_work;

import java.util.Scanner;

public class ReplaceCharacter {
    static String replaceCharacter(String str, int index) {
        if (index == str.length()) {
            return "";
        }
        char ch = str.charAt(index);
        if (ch == 'a') {
            ch = 'b';
        }
        return ch + replaceCharacter(str, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Result: " + replaceCharacter(str, 0));
        sc.close();
    }
}

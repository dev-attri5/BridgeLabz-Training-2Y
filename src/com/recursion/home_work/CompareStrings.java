package com.recursion.home_work;

import java.util.Scanner;

public class CompareStrings {
    static boolean areEqual(String str1, String str2, int index) {
        if (index == str1.length() && index == str2.length()) {
            return true;
        }
        if (index >= str1.length() || index >= str2.length()) {
            return false;
        }
        if (str1.charAt(index) != str2.charAt(index)) {
            return false;
        }
        return areEqual(str1, str2, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        System.out.println(areEqual(str1, str2, 0)
                ? "Strings are equal" : "Strings are not equal");
        sc.close();
    }
}

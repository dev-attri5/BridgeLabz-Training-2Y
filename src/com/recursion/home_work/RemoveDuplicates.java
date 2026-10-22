package com.recursion.home_work;

import java.util.Scanner;

public class RemoveDuplicates {
    static boolean contains(String str, char target, int index) {
        if (index == str.length()) {
            return false;
        }
        if (str.charAt(index) == target) {
            return true;
        }
        return contains(str, target, index + 1);
    }

    static String removeDuplicates(String str, int index, String result) {
        if (index == str.length()) {
            return result;
        }
        char ch = str.charAt(index);
        if (!contains(result, ch, 0)) {
            result = result + ch;
        }
        return removeDuplicates(str, index + 1, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("After removing duplicates: "
                + removeDuplicates(str, 0, ""));
        sc.close();
    }
}

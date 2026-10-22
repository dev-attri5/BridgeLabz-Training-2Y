package com.recursion.home_work;

import java.util.Scanner;

public class StringLength {
    // Uses recursion to count characters; length() is used only as the boundary.
    static int findLength(String str, int index) {
        if (index == str.length()) {
            return 0;
        }
        return 1 + findLength(str, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Length: " + findLength(str, 0));
        sc.close();
    }
}

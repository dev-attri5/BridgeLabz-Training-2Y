package com.Java_Strings;

import java.util.Scanner;

public class Program01_StringBuilder_Reverse {

    public static String reverseString(String text) {
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String reversed = reverseString(text);
        System.out.println("Reversed string: " + reversed);

        sc.close();
    }
}

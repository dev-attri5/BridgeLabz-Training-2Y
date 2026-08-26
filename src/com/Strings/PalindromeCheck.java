package com.Strings;

import java.util.Scanner;

public class PalindromeCheck {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your string");
            String str = sc.nextLine();

            String reversed = new StringBuilder(str).reverse().toString();

            if (str.equals(reversed)) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not a Palindrome");
            }
        }
    }

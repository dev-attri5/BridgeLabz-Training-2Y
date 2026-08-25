package com.Strings;

import java.util.Scanner;

public class isValid {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        while (true) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
            else if (s.contains("[]")) {
                s = s.replace("[]", "");
            }
            else if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
            else {
                return s.isEmpty();
            }
        }
    }
}

package com.leetcode;

import java.util.Scanner;

public class LC1047 {
 public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the String");
     String str = sc.nextLine();

     System.out.println(removeDuplicates(str));

 }
        public static String removeDuplicates(String s) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(ch);
                }
            }

            return sb.toString();
        }
    }


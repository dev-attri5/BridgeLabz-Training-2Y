package com.leetcode;

import java.util.Scanner;

public class LC3110 {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter your String");
       String s =sc.nextLine();
       System.out.println(scoreOfString(s));
   }
        public static int scoreOfString(String s) {
            int score = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                score += Math.abs(s.charAt(i) - s.charAt(i + 1));
            }
            return score;
        }

}

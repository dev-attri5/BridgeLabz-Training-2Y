package com.Strings;

import java.util.Scanner;

public class firstUniqeCh {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(firstUniqChar(s));
    }

        public static int firstUniqChar(String s) {


            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                    return i;
                }
            }

            return -1;
        }
}


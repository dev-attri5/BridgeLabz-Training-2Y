package com.recursion.advance_recursion;

import java.util.ArrayList;

public class FindSubSequence {
    public static ArrayList<String> getssq(String s) {
        ArrayList<String> result = new ArrayList<>();
        if(s.length() == 0) {
            result.add("");

            return result;
        }
            char ch = s.charAt(0);

        ArrayList<String> small = getssq(s.substring(1));

        for(String ss : small){
            result.add(ss);
            result.add(ch+ss);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(getssq(s));
    }
}

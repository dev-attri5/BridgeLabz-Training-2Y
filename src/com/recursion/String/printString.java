package com.recursion.String;

import java.util.*;

public class printString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String s1 = sc.nextLine();
       //print(s1,0);
        //printRev(s1,0);
        System.out.println(palindrome(s1,0,s1.length()-1));
    }
    public static boolean palindrome(String s,int start,int end){
        if(start>=end){
            return true;
        }
        if(s.charAt(start)==s.charAt(end)){
            return true;
        }
        palindrome(s,start+1,end-1);
        return false;
    }
    public static void printRev(String str,int index){
        if(index==str.length()){
            return;
        }
        printRev(str,index+1);
        System.out.print(str.charAt(index));
    }
    public static void print(String str, int index){
        if(index == str.length()){
            return;
        }
        System.out.print(str.charAt(index));
        print(str, index+1);

    }
}

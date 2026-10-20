package com.recursion.Basic;

public class fab {
    public static int fabo(int n){
        if(n<=1){
            return n;
        }
        return fabo(n-1)+fabo(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fabo(5));

    }
}

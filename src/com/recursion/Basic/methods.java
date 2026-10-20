package com.recursion.Basic;

public class methods {
    public static void main(String[] args) {
        int result = mul(10,20);
        System.out.println(result);

        System.out.println(mul(20,34));

        add(10,29);
    }
    public static int mul(int a, int b){
        return a*b;
    }
    public static void add(int a, int b){
       System.out.println(a+b);
    }
}

package com.recursion.Basic;

public class GCD {
    public static int lcm(int a,int b){
        if(a==b){
            return a;
        }
        return (a/gcd(b,a%b))*b;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 18;

        System.out.println("GCD = " + gcd(a, b));
        System.out.println("LCM = " + lcm(a, b));
    }
}

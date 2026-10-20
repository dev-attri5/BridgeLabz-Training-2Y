package com.recursion.Basic;

public class sumOfDIgit {
    public static int sumOFDIgit(int n){
        if(n==0){
            return 0;
        }
        return (n%10)+ sumOFDIgit(n/10);
    }
    public static void main(String[] args) {
        System.out.println(sumOFDIgit(12));
    }
}

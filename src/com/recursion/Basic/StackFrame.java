package com.recursion.Basic;

public class StackFrame {
    public static void main(String[] args) {
        method1();
    }
    public static void method1(){
        int a=10;
        method2();
        System.out.println(a);
    }
    public static void method2(){
        int a=20;
        method3();
        System.out.println(a);
    }
    public static void method3(){
        int a=30;
        System.out.println(a);
    }
}

package com.LinkedList.Basic;

public class student {
    String name;

    public student(String name){
        this.name=name;
    }
    public static void main(String[] args){
        student s=new student("Sam");
        System.out.println(s.name);
    }

}

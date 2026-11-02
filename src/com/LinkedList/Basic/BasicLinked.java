package com.LinkedList.Basic;


import java.util.*;

public class BasicLinked {
    public static void main(String[] args) {
       node a=new node(1);
      //  System.out.print(a.data+"->");
       node b=new node(2);
     //   System.out.print(b.data+"->");
      //  System.out.println(a.next);
        node c =new node(3);
        node d =new node(4);
        node e =new node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
//        System.out.print(a.data+"->");
//        System.out.print(a.next.data+"->");
//        System.out.print(a.next.next.data+"->");
//        System.out.print(a.next.next.next.data+"->");
//        System.out.print(a.next.next.next.next.data+"->");

        System.out.println();

        node temp = a;
//        for(int i=0;i<5;i++){
//            if(temp!=null) {
//                System.out.print(temp.data + "->");
//                temp = temp.next;
//            }
//        }
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }
}

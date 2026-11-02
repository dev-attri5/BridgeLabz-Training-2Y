package com.LinkedList.Basic;

public class traversal {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }
    public static Node head;
    public static Node tail;

    public static void insertAtEnd(int val){
        Node temp = new Node(val);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
    }
    public static int NodeCount(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
//        System.out.println(count);
        return  count;
    }
    public static void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    static void main(String[] args) {
        insertAtEnd(20);
        insertAtEnd(30);
        insertAtEnd(40);
        insertAtEnd(50);
        display();
        System.out.println();
       // NodeCount();
        System.out.println("Total Node is "+NodeCount());
    }
}

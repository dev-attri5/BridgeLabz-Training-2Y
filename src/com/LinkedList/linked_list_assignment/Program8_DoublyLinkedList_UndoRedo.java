package com.LinkedList.linked_list_assignment;

import java.util.Scanner;

class TextStateNode {
    String content;
    TextStateNode prev;
    TextStateNode next;

    public TextStateNode(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class Program8_DoublyLinkedList_UndoRedo {
    static TextStateNode head = null;
    static TextStateNode current = null;
    static int historySize = 0;
    static final int MAX_HISTORY = 10;

    public static void addTextState(String text) {
        TextStateNode newNode = new TextStateNode(text);

        if (head == null) {
            head = newNode;
            current = newNode;
            historySize = 1;
            return;
        }

        if (current.next != null) {
            current.next = null;
            int count = 0;
            TextStateNode temp = head;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            historySize = count;
        }

        current.next = newNode;
        newNode.prev = current;
        current = newNode;
        historySize++;

        if (historySize > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            historySize--;
        }
    }

    public static void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public static void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public static void displayCurrentState() {
        if (current == null) {
            System.out.println("Current Text: [Empty]");
        } else {
            System.out.println("Current Text: \"" + current.content + "\"");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n1. Type/Add Text State  2. Undo  3. Redo  4. Display Current Text  5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter new text content: ");
                String text = sc.nextLine();
                addTextState(text);
                displayCurrentState();
            } else if (choice == 2) {
                undo();
                displayCurrentState();
            } else if (choice == 3) {
                redo();
                displayCurrentState();
            } else if (choice == 4) {
                displayCurrentState();
            }
        }
        sc.close();
    }
}

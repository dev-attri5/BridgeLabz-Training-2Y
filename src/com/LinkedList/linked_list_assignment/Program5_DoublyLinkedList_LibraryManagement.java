package com.LinkedList.linked_list_assignment;

import java.util.Scanner;

class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

public class Program5_DoublyLinkedList_LibraryManagement {
    static BookNode head = null;
    static BookNode tail = null;

    public static void addAtBeginning(String title, String author, String genre, int id, boolean avail) {
        BookNode newNode = new BookNode(title, author, genre, id, avail);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Book added at beginning.");
    }

    public static void addAtEnd(String title, String author, String genre, int id, boolean avail) {
        BookNode newNode = new BookNode(title, author, genre, id, avail);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book added at end.");
    }

    public static void addAtPosition(int pos, String title, String author, String genre, int id, boolean avail) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, author, genre, id, avail);
            return;
        }
        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            addAtEnd(title, author, genre, id, avail);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, id, avail);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        System.out.println("Book added at position " + pos + ".");
    }

    public static void removeById(int id) {
        BookNode temp = head;
        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book ID not found.");
            return;
        }
        if (temp == head && temp == tail) {
            head = tail = null;
        } else if (temp == head) {
            head = head.next;
            head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Book ID " + id + " removed.");
    }

    public static void searchBook(String keyword) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                System.out.println("ID: " + temp.bookId + " | Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No matching book found.");
    }

    public static void updateAvailability(int id, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated for Book ID " + id + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    public static void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("\n--- Books (Forward Order) ---");
        BookNode temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + " | " + temp.title + " by " + temp.author + " (" + temp.genre + ") | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public static void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("\n--- Books (Reverse Order) ---");
        BookNode temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + " | " + temp.title + " by " + temp.author + " (" + temp.genre + ") | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public static void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 10) {
            System.out.println("\n1. Add Beginning  2. Add End  3. Add Position  4. Remove by ID");
            System.out.println("5. Search Title/Author  6. Update Availability  7. Display Forward");
            System.out.println("8. Display Reverse  9. Count Books  10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1 || choice == 2 || choice == 3) {
                int pos = 0;
                if (choice == 3) {
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                }
                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Author: ");
                String author = sc.nextLine();
                System.out.print("Enter Genre: ");
                String genre = sc.nextLine();
                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                System.out.print("Is Available (true/false): ");
                boolean avail = sc.nextBoolean();

                if (choice == 1) addAtBeginning(title, author, genre, id, avail);
                else if (choice == 2) addAtEnd(title, author, genre, id, avail);
                else addAtPosition(pos, title, author, genre, id, avail);
            } else if (choice == 4) {
                System.out.print("Enter Book ID to remove: ");
                removeById(sc.nextInt());
            } else if (choice == 5) {
                System.out.print("Enter Book Title or Author: ");
                searchBook(sc.nextLine());
            } else if (choice == 6) {
                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Availability (true/false): ");
                boolean avail = sc.nextBoolean();
                updateAvailability(id, avail);
            } else if (choice == 7) {
                displayForward();
            } else if (choice == 8) {
                displayReverse();
            } else if (choice == 9) {
                countBooks();
            }
        }
        sc.close();
    }
}

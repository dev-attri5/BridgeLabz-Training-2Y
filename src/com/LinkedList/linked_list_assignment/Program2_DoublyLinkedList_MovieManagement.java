package com.LinkedList.linked_list_assignment;

import java.util.Scanner;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class Program2_DoublyLinkedList_MovieManagement {
    static MovieNode head = null;
    static MovieNode tail = null;

    public static void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at the beginning.");
    }

    public static void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at the end.");
    }

    public static void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        System.out.println("Movie added at position " + pos + ".");
    }

    public static void removeByTitle(String title) {
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found.");
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
        System.out.println("Movie '" + title + "' removed.");
    }

    public static void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found for director: " + director);
    }

    public static void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating >= rating) {
                System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating >= " + rating);
    }

    public static void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("\n--- Movies (Forward Order) ---");
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | Dir: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public static void displayReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("\n--- Movies (Reverse Order) ---");
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | Dir: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for '" + title + "'.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 10) {
            System.out.println("\n1. Add Beginning  2. Add End  3. Add Position  4. Remove by Title");
            System.out.println("5. Search Director  6. Search Rating  7. Display Forward  8. Display Reverse");
            System.out.println("9. Update Rating  10. Exit");
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
                System.out.print("Enter Movie Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Director: ");
                String dir = sc.nextLine();
                System.out.print("Enter Release Year: ");
                int year = sc.nextInt();
                System.out.print("Enter Rating: ");
                double rating = sc.nextDouble();

                if (choice == 1) addAtBeginning(title, dir, year, rating);
                else if (choice == 2) addAtEnd(title, dir, year, rating);
                else addAtPosition(pos, title, dir, year, rating);
            } else if (choice == 4) {
                System.out.print("Enter Movie Title to remove: ");
                removeByTitle(sc.nextLine());
            } else if (choice == 5) {
                System.out.print("Enter Director Name: ");
                searchByDirector(sc.nextLine());
            } else if (choice == 6) {
                System.out.print("Enter Minimum Rating: ");
                searchByRating(sc.nextDouble());
            } else if (choice == 7) {
                displayForward();
            } else if (choice == 8) {
                displayReverse();
            } else if (choice == 9) {
                System.out.print("Enter Movie Title: ");
                String title = sc.nextLine();
                System.out.print("Enter New Rating: ");
                double rating = sc.nextDouble();
                updateRating(title, rating);
            }
        }
        sc.close();
    }
}

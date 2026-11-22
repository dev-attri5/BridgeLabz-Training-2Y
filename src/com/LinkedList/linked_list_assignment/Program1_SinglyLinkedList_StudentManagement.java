package com.LinkedList.linked_list_assignment;

import java.util.Scanner;

class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class Program1_SinglyLinkedList_StudentManagement {
    static StudentNode head = null;

    public static void addAtBeginning(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
        System.out.println("Student added at the beginning.");
    }

    public static void addAtEnd(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            System.out.println("Student added as first record.");
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Student added at the end.");
    }

    public static void addAtPosition(int pos, int roll, String name, int age, String grade) {
        if (pos <= 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        StudentNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range. Adding at the end.");
            addAtEnd(roll, name, age, grade);
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Student added at position " + pos + ".");
    }

    public static void deleteByRollNumber(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Student with Roll No " + roll + " deleted.");
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student with Roll No " + roll + " deleted.");
        }
    }

    public static void searchByRollNumber(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Found -> Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + roll + " not found.");
    }

    public static void displayAll() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        StudentNode temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + " | Name: " + temp.name + " | Age: " + temp.age + " | Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void updateGrade(int roll, String newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated for Roll No " + roll + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + roll + " not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            System.out.println("\n1. Add at Beginning  2. Add at End  3. Add at Position");
            System.out.println("4. Delete by Roll    5. Search      6. Display All");
            System.out.println("7. Update Grade      8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1 || choice == 2 || choice == 3) {
                int pos = 0;
                if (choice == 3) {
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                }
                System.out.print("Enter Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Grade: ");
                String grade = sc.nextLine();

                if (choice == 1) addAtBeginning(roll, name, age, grade);
                else if (choice == 2) addAtEnd(roll, name, age, grade);
                else addAtPosition(pos, roll, name, age, grade);
            } else if (choice == 4) {
                System.out.print("Enter Roll Number to delete: ");
                deleteByRollNumber(sc.nextInt());
            } else if (choice == 5) {
                System.out.print("Enter Roll Number to search: ");
                searchByRollNumber(sc.nextInt());
            } else if (choice == 6) {
                displayAll();
            } else if (choice == 7) {
                System.out.print("Enter Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter New Grade: ");
                String grade = sc.nextLine();
                updateGrade(roll, grade);
            }
        }
        sc.close();
    }
}

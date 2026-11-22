package com.LinkedList.linked_list_assignment;

import java.util.Scanner;

class TaskNode {
    int taskId;
    String taskName;
    String priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, String priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class Program3_CircularLinkedList_TaskScheduler {
    static TaskNode head = null;
    static TaskNode currentTask = null;

    public static void addAtBeginning(int id, String name, String priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            currentTask = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        System.out.println("Task added at beginning.");
    }

    public static void addAtEnd(int id, String name, String priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            currentTask = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Task added at end.");
    }

    public static void addAtPosition(int pos, int id, String name, String priority, String dueDate) {
        if (pos <= 1 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        TaskNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Task added at position " + pos + ".");
    }

    public static void removeById(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        TaskNode curr = head;
        TaskNode prev = null;

        do {
            if (curr.taskId == id) {
                if (curr == head && curr.next == head) {
                    head = null;
                    currentTask = null;
                } else if (curr == head) {
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    if (currentTask == curr) currentTask = head;
                } else {
                    prev.next = curr.next;
                    if (currentTask == curr) currentTask = curr.next;
                }
                System.out.println("Task ID " + id + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task ID not found.");
    }

    public static void viewAndMoveNext() {
        if (currentTask == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        System.out.println("Current Task -> ID: " + currentTask.taskId + " | Name: " + currentTask.taskName + " | Priority: " + currentTask.priority + " | Due: " + currentTask.dueDate);
        currentTask = currentTask.next;
    }

    public static void displayAll() {
        if (head == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }
        System.out.println("\n--- All Scheduled Tasks ---");
        TaskNode temp = head;
        do {
            System.out.println("ID: " + temp.taskId + " | Name: " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public static void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                System.out.println("ID: " + temp.taskId + " | Name: " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tasks found with priority: " + priority);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            System.out.println("\n1. Add Beginning  2. Add End  3. Add Position  4. Remove by ID");
            System.out.println("5. Current & Next Task  6. Display All  7. Search Priority  8. Exit");
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
                System.out.print("Enter Task ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Task Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Priority (High/Medium/Low): ");
                String priority = sc.nextLine();
                System.out.print("Enter Due Date: ");
                String due = sc.nextLine();

                if (choice == 1) addAtBeginning(id, name, priority, due);
                else if (choice == 2) addAtEnd(id, name, priority, due);
                else addAtPosition(pos, id, name, priority, due);
            } else if (choice == 4) {
                System.out.print("Enter Task ID to remove: ");
                removeById(sc.nextInt());
            } else if (choice == 5) {
                viewAndMoveNext();
            } else if (choice == 6) {
                displayAll();
            } else if (choice == 7) {
                System.out.print("Enter Priority to search: ");
                searchByPriority(sc.nextLine());
            }
        }
        sc.close();
    }
}

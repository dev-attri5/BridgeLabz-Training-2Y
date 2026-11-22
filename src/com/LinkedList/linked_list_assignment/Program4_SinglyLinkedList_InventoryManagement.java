package com.LinkedList.linked_list_assignment;

import java.util.Scanner;

class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class Program4_SinglyLinkedList_InventoryManagement {
    static ItemNode head = null;

    public static void addAtBeginning(String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        newNode.next = head;
        head = newNode;
        System.out.println("Item added at beginning.");
    }

    public static void addAtEnd(String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Item added at end.");
    }

    public static void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        ItemNode newNode = new ItemNode(name, id, qty, price);
        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Item added at position " + pos + ".");
    }

    public static void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item ID " + id + " removed.");
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item ID not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item ID " + id + " removed.");
        }
    }

    public static void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated for Item ID " + id + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    public static void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                System.out.println("Found -> ID: " + temp.itemId + " | Name: " + temp.itemName + " | Qty: " + temp.quantity + " | Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public static void searchByName(String name) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                System.out.println("Found -> ID: " + temp.itemId + " | Name: " + temp.itemName + " | Qty: " + temp.quantity + " | Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public static void displayTotalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total = total + (temp.price * temp.quantity);
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public static ItemNode mergeSort(ItemNode h, int sortBy, boolean ascending) {
        if (h == null || h.next == null) {
            return h;
        }
        ItemNode middle = getMiddle(h);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(h, sortBy, ascending);
        ItemNode right = mergeSort(nextOfMiddle, sortBy, ascending);

        return sortedMerge(left, right, sortBy, ascending);
    }

    public static ItemNode sortedMerge(ItemNode a, ItemNode b, int sortBy, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (sortBy == 1) {
            int cmp = a.itemName.compareToIgnoreCase(b.itemName);
            condition = ascending ? (cmp <= 0) : (cmp >= 0);
        } else {
            condition = ascending ? (a.price <= b.price) : (a.price >= b.price);
        }

        ItemNode result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, sortBy, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, sortBy, ascending);
        }
        return result;
    }

    public static ItemNode getMiddle(ItemNode h) {
        if (h == null) return h;
        ItemNode slow = h, fast = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- Inventory List ---");
        ItemNode temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + " | Name: " + temp.itemName + " | Qty: " + temp.quantity + " | Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 10) {
            System.out.println("\n1. Add Beginning  2. Add End  3. Add Position  4. Remove by ID");
            System.out.println("5. Update Qty  6. Search ID  7. Search Name  8. Total Value");
            System.out.println("9. Sort Inventory  10. Exit");
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
                System.out.print("Enter Item Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Item ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                if (choice == 1) addAtBeginning(name, id, qty, price);
                else if (choice == 2) addAtEnd(name, id, qty, price);
                else addAtPosition(pos, name, id, qty, price);
            } else if (choice == 4) {
                System.out.print("Enter Item ID to remove: ");
                removeById(sc.nextInt());
            } else if (choice == 5) {
                System.out.print("Enter Item ID: ");
                int id = sc.nextInt();
                System.out.print("Enter New Quantity: ");
                int qty = sc.nextInt();
                updateQuantity(id, qty);
            } else if (choice == 6) {
                System.out.print("Enter Item ID: ");
                searchById(sc.nextInt());
            } else if (choice == 7) {
                System.out.print("Enter Item Name: ");
                searchByName(sc.nextLine());
            } else if (choice == 8) {
                displayTotalValue();
            } else if (choice == 9) {
                System.out.print("Sort by (1 = Name, 2 = Price): ");
                int sortBy = sc.nextInt();
                System.out.print("Order (1 = Ascending, 2 = Descending): ");
                int order = sc.nextInt();
                head = mergeSort(head, sortBy, order == 1);
                displayAll();
            }
        }
        sc.close();
    }
}

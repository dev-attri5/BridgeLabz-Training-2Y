package com.LinkedList.linked_list_assignment;

import java.util.Scanner;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendHead;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}

public class Program7_SinglyLinkedList_SocialMedia {
    static UserNode head = null;

    public static void addUser(int id, String name, int age) {
        UserNode newNode = new UserNode(id, name, age);
        if (head == null) {
            head = newNode;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("User '" + name + "' added.");
    }

    public static UserNode findUserById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public static void addFriendId(UserNode user, int friendId) {
        FriendNode temp = user.friendHead;
        while (temp != null) {
            if (temp.friendId == friendId) return;
            temp = temp.next;
        }
        FriendNode newNode = new FriendNode(friendId);
        if (user.friendHead == null) {
            user.friendHead = newNode;
        } else {
            temp = user.friendHead;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    public static void removeFriendId(UserNode user, int friendId) {
        FriendNode temp = user.friendHead;
        FriendNode prev = null;
        while (temp != null) {
            if (temp.friendId == friendId) {
                if (prev == null) user.friendHead = temp.next;
                else prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public static boolean hasFriend(UserNode user, int friendId) {
        FriendNode temp = user.friendHead;
        while (temp != null) {
            if (temp.friendId == friendId) return true;
            temp = temp.next;
        }
        return false;
    }

    public static void showFriendIds(UserNode user) {
        FriendNode temp = user.friendHead;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.friendId);
            if (temp.next != null) System.out.print(", ");
            temp = temp.next;
        }
        System.out.print("]");
    }

    public static int countFriendIds(UserNode user) {
        int count = 0;
        FriendNode temp = user.friendHead;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void addFriendConnection(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        addFriendId(u1, id2);
        addFriendId(u2, id1);
        System.out.println("Friend connection added between " + u1.name + " and " + u2.name + ".");
    }

    public static void removeFriendConnection(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        removeFriendId(u1, id2);
        removeFriendId(u2, id1);
        System.out.println("Friend connection removed.");
    }

    public static void findMutualFriends(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        System.out.print("Mutual Friends IDs: ");
        boolean found = false;
        FriendNode temp = u1.friendHead;
        while (temp != null) {
            int fId = temp.friendId;
            if (hasFriend(u2, fId)) {
                System.out.print(fId + " ");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.print("None");
        System.out.println();
    }

    public static void displayFriends(int id) {
        UserNode u = findUserById(id);
        if (u == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Friends of " + u.name + " (IDs): ");
        showFriendIds(u);
        System.out.println();
    }

    public static void searchUser(String query) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(query) || String.valueOf(temp.userId).equals(query)) {
                System.out.println("Found -> ID: " + temp.userId + " | Name: " + temp.name + " | Age: " + temp.age + " | Friends: ");
                showFriendIds(temp);
                System.out.println();
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public static void countFriendsForAll() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println("User: " + temp.name + " (ID: " + temp.userId + ") -> Total Friends: " + countFriendIds(temp));
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            System.out.println("\\n1. Add User  2. Add Friend  3. Remove Friend  4. Mutual Friends");
            System.out.println("5. Display User Friends  6. Search User  7. Count Friends  8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter User ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                addUser(id, name, age);
            } else if (choice == 2) {
                System.out.print("Enter First User ID: ");
                int id1 = sc.nextInt();
                System.out.print("Enter Second User ID: ");
                int id2 = sc.nextInt();
                addFriendConnection(id1, id2);
            } else if (choice == 3) {
                System.out.print("Enter First User ID: ");
                int id1 = sc.nextInt();
                System.out.print("Enter Second User ID: ");
                int id2 = sc.nextInt();
                removeFriendConnection(id1, id2);
            } else if (choice == 4) {
                System.out.print("Enter First User ID: ");
                int id1 = sc.nextInt();
                System.out.print("Enter Second User ID: ");
                int id2 = sc.nextInt();
                findMutualFriends(id1, id2);
            } else if (choice == 5) {
                System.out.print("Enter User ID: ");
                displayFriends(sc.nextInt());
            } else if (choice == 6) {
                System.out.print("Enter Name or User ID: ");
                searchUser(sc.nextLine());
            } else if (choice == 7) {
                countFriendsForAll();
            }
        }
        sc.close();
    }
}

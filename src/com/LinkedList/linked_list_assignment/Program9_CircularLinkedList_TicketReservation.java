package com.LinkedList.linked_list_assignment;

import java.util.Scanner;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class Program9_CircularLinkedList_TicketReservation {
    static TicketNode head = null;

    public static void bookTicket(int id, String customer, String movie, String seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            TicketNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Ticket booked successfully (ID: " + id + ").");
    }

    public static void cancelTicket(int id) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode curr = head;
        TicketNode prev = null;

        do {
            if (curr.ticketId == id) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else if (curr == head) {
                    TicketNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Ticket ID " + id + " cancelled.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket ID not found.");
    }

    public static void displayTickets() {
        if (head == null) {
            System.out.println("No booked tickets to display.");
            return;
        }
        System.out.println("\n--- Booked Tickets ---");
        TicketNode temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + " | Customer: " + temp.customerName + " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public static void searchTicket(String query) {
        if (head == null) {
            System.out.println("No booked tickets.");
            return;
        }
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket ID: " + temp.ticketId + " | Customer: " + temp.customerName + " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No matching ticket found.");
    }

    public static void countBookedTickets() {
        if (head == null) {
            System.out.println("Total Booked Tickets: 0");
            return;
        }
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Booked Tickets: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n1. Book Ticket  2. Cancel Ticket  3. Display All Tickets");
            System.out.println("4. Search Customer/Movie  5. Total Booked Count  6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Ticket ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Customer Name: ");
                String customer = sc.nextLine();
                System.out.print("Enter Movie Name: ");
                String movie = sc.nextLine();
                System.out.print("Enter Seat Number: ");
                String seat = sc.nextLine();
                System.out.print("Enter Booking Time: ");
                String time = sc.nextLine();
                bookTicket(id, customer, movie, seat, time);
            } else if (choice == 2) {
                System.out.print("Enter Ticket ID to cancel: ");
                cancelTicket(sc.nextInt());
            } else if (choice == 3) {
                displayTickets();
            } else if (choice == 4) {
                System.out.print("Enter Customer Name or Movie Name: ");
                searchTicket(sc.nextLine());
            } else if (choice == 5) {
                countBookedTickets();
            }
        }
        sc.close();
    }
}

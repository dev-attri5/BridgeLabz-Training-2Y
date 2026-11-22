package com.LinkedList.linked_list_assignment;

import java.util.Scanner;

class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

public class Program6_CircularLinkedList_RoundRobin {
    static ProcessNode head = null;

    public static void addProcess(int id, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(id, burstTime, priority);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public static void removeProcess(int id) {
        if (head == null) return;

        ProcessNode curr = head;
        ProcessNode prev = null;
        do {
            if (curr.processId == id) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else if (curr == head) {
                    ProcessNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public static void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty (All processes completed).");
            return;
        }
        ProcessNode temp = head;
        do {
            System.out.print("[P" + temp.processId + " | RemTime: " + temp.remainingTime + " | Prio: " + temp.priority + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }

    public static void simulateRoundRobin(int timeQuantum, int totalProcesses) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int round = 1;

        ProcessNode current = head;

        while (head != null) {
            System.out.println("\n--- Round " + round + " ---");
            int execTime = Math.min(current.remainingTime, timeQuantum);
            current.remainingTime -= execTime;
            currentTime += execTime;

            System.out.println("Executing Process P" + current.processId + " for " + execTime + " units (Current Time: " + currentTime + ")");

            ProcessNode nextProcess = current.next;

            if (current.remainingTime == 0) {
                current.turnaroundTime = currentTime;
                current.waitingTime = current.turnaroundTime - current.burstTime;

                totalTurnaroundTime += current.turnaroundTime;
                totalWaitingTime += current.waitingTime;

                System.out.println("Process P" + current.processId + " finished! Turnaround: " + current.turnaroundTime + ", Waiting: " + current.waitingTime);
                int finishedId = current.processId;
                if (current.next == current) {
                    removeProcess(finishedId);
                    current = null;
                } else {
                    removeProcess(finishedId);
                    current = nextProcess;
                }
            } else {
                current = nextProcess;
            }

            displayQueue();
            round++;
        }

        double avgWaiting = (double) totalWaitingTime / totalProcesses;
        double avgTurnaround = (double) totalTurnaroundTime / totalProcesses;

        System.out.println("\n========================================");
        System.out.println("Average Waiting Time   : " + avgWaiting);
        System.out.println("Average Turnaround Time: " + avgTurnaround);
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1) + ":");
            System.out.print("  Process ID: ");
            int id = sc.nextInt();
            System.out.print("  Burst Time: ");
            int burst = sc.nextInt();
            System.out.print("  Priority: ");
            int prio = sc.nextInt();
            addProcess(id, burst, prio);
        }

        System.out.print("Enter Fixed Time Quantum: ");
        int tq = sc.nextInt();

        simulateRoundRobin(tq, n);
        sc.close();
    }
}

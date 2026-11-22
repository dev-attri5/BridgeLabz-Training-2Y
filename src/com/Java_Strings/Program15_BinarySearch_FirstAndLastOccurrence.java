package com.Java_Strings;

import java.util.Scanner;

public class Program15_BinarySearch_FirstAndLastOccurrence {

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return first;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return last;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of sorted array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        if (first != -1) {
            System.out.println("First occurrence index: " + first);
            System.out.println("Last occurrence index : " + last);
        } else {
            System.out.println("Element not found (-1).");
        }

        sc.close();
    }
}

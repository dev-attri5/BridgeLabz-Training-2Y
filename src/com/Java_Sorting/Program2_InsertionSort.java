package com.Java_Sorting;

import java.util.Scanner;

public class Program2_InsertionSort {

    public static void insertionSort(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int current = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > current) {
                ids[j + 1] = ids[j];
                j--;
            }

            ids[j + 1] = current;
        }
    }

    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] empIds = new int[n];
        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            empIds[i] = sc.nextInt();
        }

        System.out.print("Original Employee IDs: ");
        displayArray(empIds);

        insertionSort(empIds);

        System.out.print("Sorted Employee IDs (Ascending): ");
        displayArray(empIds);

        sc.close();
    }
}

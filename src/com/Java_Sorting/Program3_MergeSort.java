package com.Java_Sorting;

import java.util.Scanner;

public class Program3_MergeSort {

    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            merge(prices, left, mid, right);
        }
    }

    public static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = prices[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k] = leftArr[i];
                i++;
            } else {
                prices[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void displayArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }

        System.out.print("Original Book Prices: ");
        displayArray(prices);

        mergeSort(prices, 0, n - 1);

        System.out.print("Sorted Book Prices (Ascending): ");
        displayArray(prices);

        sc.close();
    }
}

package com.Java_Sorting;

import java.util.Scanner;

public class Program5_SelectionSort {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
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

        System.out.print("Enter number of exam scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Original Exam Scores: ");
        displayArray(scores);

        selectionSort(scores);

        System.out.print("Sorted Exam Scores (Ascending): ");
        displayArray(scores);

        sc.close();
    }
}

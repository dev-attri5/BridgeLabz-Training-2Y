package com.Java_Strings;

import java.util.Scanner;

public class Program13_BinarySearch_PeakElement {

    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            boolean leftSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightSmaller = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            if (leftSmaller && rightSmaller) {
                return arr[mid];
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int peak = findPeakElement(arr);
        System.out.println("Peak element: " + peak);

        sc.close();
    }
}

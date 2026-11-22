package com.Java_Strings;

import java.util.Scanner;

public class Program12_BinarySearch_RotationPoint {

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of rotated sorted array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element (rotation point value): " + arr[rotationIndex]);

        sc.close();
    }
}

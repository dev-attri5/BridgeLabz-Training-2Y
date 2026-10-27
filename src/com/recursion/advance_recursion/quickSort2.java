package com.recursion.advance_recursion;

public class quickSort2 {


        static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);

                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;

            int j = low;
            while (j < high) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
                j++;
            }

            swap(arr, i + 1, high);
            return i + 1;
        }

        static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {
            int[] arr = {10, 7, 8, 9, 1, 5};

            quickSort(arr, 0, arr.length - 1);

            int k = 0;
            while (k < arr.length) {
                System.out.print(arr[k] + " ");
                k++;
            }
        }
    }


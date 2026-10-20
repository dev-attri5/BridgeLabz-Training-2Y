package com.recursion.Array;

public class search {
    public static int search(int[] arr, int index, int target) {
        if (index == arr.length) {
            return -1;
        }
        if(arr[index] == target) {
            return index;
        }
        return search(arr, index + 1, target);
    }

    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(arr, 0, 5));
    }
}

package com.recursion.Array;

import java.util.Arrays;

public class sum {
    public static int sum(int[] arr, int index) {
        if(index==arr.length){
            return 0;
        }
        int add = sum(arr, index + 1);
        return arr[index] + add;
    }
    public static void main(String[] args) {
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum(arr, 0));
    }
}

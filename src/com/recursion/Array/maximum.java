package com.recursion.Array;

public class maximum {
    public static int maximum(int arr[], int index){
        if(index == arr.length-1){
            return arr[index];
        }
        int small= maximum(arr, index+1);
        return Math.max(arr[index],small);
    }
    public static void main(String[] args) {
      int[] arr = {1,2,3,4,5};
        System.out.println(maximum(arr, 0));
    }
}

package com.recursion.Array;

public class print {
    public static void printint(int arr[] , int index){
        if(index == arr.length){
            return;
        }
        System.out.print(arr[index]);
      //  System.out.print(arr[index]);
        printint(arr,index+1);
    }
    public static void main(String[] args) {
        int arr[] = {1,23,4,5,6,7,8,9,9,0};
        printint(arr,0);

    }
}

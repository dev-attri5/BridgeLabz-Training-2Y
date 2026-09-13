package leetcode;

import java.util.Scanner;

public class LC3065 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the of the array");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        System.out.println(minOperations(arr,k));
    }
        public static int minOperations(int[] nums, int k) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < k) {
                    count++;
                }
            }

            return count;
        }

}

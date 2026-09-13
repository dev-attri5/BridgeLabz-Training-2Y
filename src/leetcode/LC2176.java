package leetcode;

import java.util.Scanner;

public class LC2176 {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(countPairs(arr,k));
    }

    public static int countPairs(int[] nums, int k) {
        int count = 0;

        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i]==nums[j] && (i*j)%k == 0){
                    count++;
                }
            }
        }
        return count;
    }
}

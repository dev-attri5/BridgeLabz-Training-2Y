package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class LC1299 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the element of the array");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(replaceElements(arr)));
    }
        public static int[] replaceElements(int[] nums) {
            int maxRight = -1;

            for(int i = nums.length-1; i>=0; i--){
                int temp = nums[i];
                nums[i] = maxRight;
                maxRight = Math.max(maxRight, temp);
            }
            return nums;
        }

}

package slidingwidows;

import java.util.Scanner;

public class slidingWindow {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr =  new int[n];
        System.out.println("Enter the elements of the array");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the size of the window");
        int k = sc.nextInt();
        System.out.println(maxSumSubarray(arr,k));
    }
    public static int maxSumSubarray(int[] nums, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum = windowSum + nums[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
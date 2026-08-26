package leetcode;

import java.util.Scanner;

public class LC1512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");

        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();

        }
        System.out.println(numIdenticalPairs(arr));
    }
        public static int numIdenticalPairs(int[] nums) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }
            }

            return count;
        }
}

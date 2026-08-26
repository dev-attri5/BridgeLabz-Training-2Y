package leetcode;

import java.util.Scanner;

public class LC2535 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");

        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();

        }
        System.out.println(differenceOfSum(arr));
    }
        public static int differenceOfSum(int[] nums) {
            int elementSum = 0;
            int digitSum = 0;

            for(int i = 0; i < nums.length; i++) {
                int num = nums[i];
                elementSum += num;

                while (num > 0) {
                    digitSum += num % 10;
                    num /= 10;
                }
            }

            return elementSum - digitSum;
        }
}


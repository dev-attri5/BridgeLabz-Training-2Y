package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class LC167 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array");

        int[] arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the target");
        int target = sc.nextInt();
        System.out.print(Arrays.toString(twoSum(arr, target)));
    }
        public static int[] twoSum(int[] numbers, int target) {
            int start = 0;
            int end = numbers.length-1;

            while(start < end) {
                int sum = numbers[start] + numbers[end];

                if(sum == target){
                    return new int[]{start + 1, end + 1};

                }
                else if(sum < target) {
                    start++;
                }
                else {
                    end--;
                }
            }
            return new int[]{-1,-1};
        }
}


package leetcode;

import java.util.Scanner;

public class LC11 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter the array elements");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxArea(arr));
    }
        public static int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;

            while (left < right) {
                int width = right - left;
                int h = Math.min(height[left], height[right]);

                maxArea = Math.max(maxArea, width * h);

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
}


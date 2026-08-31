package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class LC88 {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the size of the nums1");
       int p = sc.nextInt();
       System.out.println("Enter the size of the nums2");
       int q = sc.nextInt();
       int[] nums1 = new int[p];
       int[] nums2 = new int[q];
       System.out.println("Enter the element of the nums1");
       for(int i = 0; i<p; i++){
           nums1[i] = sc.nextInt();
       }
       System.out.println("Enter the element of the nums2");
       for(int i = 0; i<q; i++){
           nums2[i] = sc.nextInt();
       }
       System.out.println("Enter the m");
       int m = sc.nextInt();
       System.out.println("Enter the n");
       int n = sc.nextInt();
       System.out.println(Arrays.toString(merge(nums1,m,nums2,n)));



   }
        public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1;
            int j = n-1;

            for(int k = m+n - 1; j>=0; k--){
                if(i >= 0 && nums1[i] > nums2[j]){
                    nums1[k] = nums1[i--];
                }
                else {
                    nums1[k] = nums2[j--];
                }
            }
            return nums1;
        }
}

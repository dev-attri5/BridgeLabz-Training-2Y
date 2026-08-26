import java.util.Arrays;
import java.util.Scanner;

public class moveZeroesa {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
     moveZeroes(arr);

    }
        public static void moveZeroes(int[] nums) {
            int left = 0;

            for (int right = 0; right < nums.length; right++) {
                if (nums[right] != 0) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
                }
            }
            System.out.println( Arrays.toString(nums));
        }

}

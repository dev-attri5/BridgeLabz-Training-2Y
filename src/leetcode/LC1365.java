import java.util.Arrays;
public class LC1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] frequency = new int[101];
        for (int num : nums) {
            frequency[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            frequency[i] += frequency[i - 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = frequency[nums[i] - 1];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] result = smallerNumbersThanCurrent(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
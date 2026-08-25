public class LC2733 {
    public static int findNonMinOrMax(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        for (int num : nums) {
            if (num != min && num != max) return num;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4};
        System.out.println(findNonMinOrMax(nums));
    }
}
public class LC414 {
    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num : nums) {
            long value = num;
            if (value == first || value == second || value == third) {
                continue;
            }
            if (value > first) {
                third = second;
                second = first;
                first = value;
            } else if (value > second) {
                third = second;
                second = value;
            } else if (value > third) {
                third = value;
            }
        }
        if (third == Long.MIN_VALUE) {
            return (int) first;
        }
        return (int) third;
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int result = thirdMax(nums);
        System.out.println("Third maximum number: " + result);
    }
}
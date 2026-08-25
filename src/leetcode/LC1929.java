import java.util.Arrays;

public class LC1929 {

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] answer = new int[2 * n];

        for (int i = 0; i < n; i++) {
            answer[i] = nums[i];
            answer[i + n] = nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        int[] result = getConcatenation(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
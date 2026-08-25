import java.util.Arrays;
public class LC349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[1001];
        boolean[] common = new boolean[1001];
        for (int num : nums1) seen[num] = true;
        for (int num : nums2) {
            if (seen[num]) common[num] = true;
        }
        int count = 0;
        for (boolean value : common) {
            if (value) count++;
        }
        int[] result = new int[count];
        int index = 0;
        for (int num = 0; num <= 1000; num++) {
            if (common[num]) result[index++] = num;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
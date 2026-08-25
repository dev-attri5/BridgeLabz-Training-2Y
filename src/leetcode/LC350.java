import java.util.Arrays;
public class LC350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] frequency = new int[1001];
        for (int num : nums1) frequency[num]++;
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) {
            if (frequency[num] > 0) {
                result[index++] = num;
                frequency[num]--;
            }
        }
        return Arrays.copyOf(result, index);
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
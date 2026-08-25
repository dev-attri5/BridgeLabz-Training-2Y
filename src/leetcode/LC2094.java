import java.util.Arrays;
public class LC2094 {
    public static int[] findEvenNumbers(int[] digits) {
        boolean[] possible = new boolean[1000];
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < digits.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j || digits[k] % 2 != 0) {
                        continue;
                    }
                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                    possible[number] = true;
                }
            }
        }
        int count = 0;
        for (int number = 100; number <= 999; number++) {
            if (possible[number]) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int number = 100; number <= 999; number++) {
            if (possible[number]) {
                result[index++] = number;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] digits = {2, 1, 3, 0};
        System.out.println("Input: " + Arrays.toString(digits));
        System.out.println("Output: " + Arrays.toString(findEvenNumbers(digits)));
    }
}
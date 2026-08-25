import java.util.Arrays;
public class LC2595 {
    public static int[] evenOddBit(int n) {
        int even = 0, odd = 0, index = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (index % 2 == 0) even++;
                else odd++;
            }
            n >>= 1;
            index++;
        }
        return new int[]{even, odd};
    }
    public static void main(String[] args) {
        int n = 50;
        System.out.println("Input: " + n);
        System.out.println("Output: " + Arrays.toString(evenOddBit(n)));
    }
}
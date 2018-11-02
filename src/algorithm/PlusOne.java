package algorithm;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne (int[] digits) {
        int gt10 = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + gt10;
            digits[i] = num % 10;
            gt10 = num / 10;
        }
        if (gt10 != 0) {
            int[] nums = new int[digits.length + 1];
            System.arraycopy(digits, 0, nums, 1, digits.length);
            nums[0] = gt10;

            return nums;
        }

        return digits;
    }

    public static void main (String[] args) {
        int digits[] = {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}

package algorithm;

import java.util.Arrays;

public class SpiralMatix2 {
    public int[][] generateMatrix (int n) {
        int[][] nums = new int[n][n];
        int left = 0, right = n - 1, top = 0, tail = n - 1;
        setVal(nums, 1, left, right, top, tail);

        return nums;
    }

    public void setVal (int[][] nums, int k, int left, int right, int top, int tail) {
        if (left <= right) {
            for (int i = left; i <= right; i++) {
                nums[top][i] = k++;
            }
            for (int i = top + 1; i <= tail; i++) {
                nums[i][right] = k++;
            }
            for (int i = right - 1; i >= left; i--) {
                nums[tail][i] = k++;
            }
            for (int i = tail - 1; i > top; i--) {
                nums[i][left] = k++;
            }

            if (right - left > 1) {
                setVal(nums, k, left + 1, right - 1, top + 1, tail - 1);
            }
        }
    }

    public static void main (String[] args) {
        SpiralMatix2 test = new SpiralMatix2();
        int[][] nums = test.generateMatrix(3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        int[] s = new int[11];
        int [] ss = new int [s.length + 1];
        System.arraycopy(s, 0, ss, 1, s.length);
    }
}

package algorithm;

import java.util.Arrays;

public class 螺旋矩阵2 {
    public int[][] generateMatrix (int n) {
        if (n <= 0) {
            return null;
        }

        int[][] nums = new int[n][n];
        print(nums, 1, 0, n - 1);
        return nums;
    }

    public void print (int[][] nums, int k, int b, int e) {
        if (b <= e) {
            for (int i = b; i <= e; i++) {
                nums[b][i] = k++;
            }
            for (int i = b + 1; i <= e; i++) {
                nums[i][e] = k++;
            }
            for (int i = e - 1; i >= b; i--) {
                nums[e][i] = k++;
            }
            for (int i = e - 1; i > b; i--) {
                nums[i][b] = k++;
            }

            if (e - b >= 2) {
                print(nums, k, b + 1, e - 1);
            }
        }
    }

    public static void main (String[] args) {
        螺旋矩阵2 test = new 螺旋矩阵2();
        int[][] nums = test.generateMatrix(3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}

package algorithm;

import java.util.Arrays;

public class Rotate {
    public void rotate (int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }

        rotate(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1);
    }

    public void rotate (int[][] matrix, int l, int r, int t, int e) {
        int n = matrix.length;
        if (r - l > 0) {
            //matrix[x][y]->matrix[y][n - x - 1]
            for (int i = l; i < r; i++) {
                int temp = matrix[i][t];
                matrix[i][t] = matrix[n - t - 1][i];
                matrix[n - t - 1][i] = matrix[n - i - 1][n - t - 1];
                matrix[n - i - 1][n - t - 1] = matrix[t][n - i - 1];
                matrix[t][n - i - 1] = temp;
            }

            rotate(matrix, l + 1, r - 1, t + 1, e - 1);
        }
    }

    public static void main (String[] args) {
        int[][] nums = {{2, 29, 20, 26, 16, 28},
                {12, 27, 9, 25, 13, 21},
                {32, 33, 32, 2, 28, 14},
                {13, 14, 32, 27, 22, 26},
                {33, 1, 20, 7, 21, 7},
                {4, 24, 1, 6, 32, 34}};

        Rotate rotate = new Rotate();
        rotate.rotate(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}

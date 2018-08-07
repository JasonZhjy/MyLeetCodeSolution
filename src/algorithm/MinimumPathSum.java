package algorithm;

import java.util.Arrays;

/**
 * 64. Minimum Path Sum
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        // init
        int[][] tab = new int[m][n];
        tab[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            tab[i][0] = grid[i][0] + tab[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            tab[0][i] = grid[0][i] + tab[0][i - 1];
        }

        // compute
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                tab[i][j] = grid[i][j] + Math.min(tab[i - 1][j], tab[i][j - 1]);
            }
        }

        for (int[] t : tab)
            System.out.println(Arrays.toString(t));

        return tab[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum test = new MinimumPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(test.minPathSum(grid));
    }
}

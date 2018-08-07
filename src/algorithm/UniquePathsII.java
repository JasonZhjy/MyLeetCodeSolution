package algorithm;

import java.util.Arrays;

/**
 * 63. Unique Paths II
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] nums = new int[m][n];
        // init
        boolean isNotObstacle = true;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && isNotObstacle) {
                nums[i][0] = 1;
            } else {
                isNotObstacle = false;
                nums[i][0] = 0;
            }
        }
        isNotObstacle = true;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0 && isNotObstacle) {
                nums[0][i] = 1;
            } else {
                isNotObstacle = false;
                nums[0][i] = 0;
            }
        }

        // compute
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = obstacleGrid[i][j] == 0 ? nums[i - 1][j] + nums[i][j - 1] : 0;
            }
        }

        return nums[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII test = new UniquePathsII();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
    }
}

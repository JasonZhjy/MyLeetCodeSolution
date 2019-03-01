package algorithm;

import java.util.Arrays;

/**
 * LeetCode 200.
 */
public class NumberOfIslands {
    private final static int[] dw = {0, -1, 0, 1};
    private final static int[] dh = {-1, 0, 1, 0};

    public int numIslands (char[][] grid) {
        int rs = 0;
        if (grid == null || grid.length == 0) {
            return rs;
        }
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[grid.length][n];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(isVisited[i], false);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    dfs(grid, i, j, isVisited);
                    rs++;
                }
            }
        }

        return rs;
    }

    public int dfs (char[][] grid, int i, int j, boolean[][] isVisited) {
        int rs = 0;
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1' && !isVisited[i][j]) {
            isVisited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                rs += dfs(grid, i + dw[k], j + dh[k], isVisited);
            }
            rs++;
        }

        return rs;
    }

    public static void main (String[] args) {

    }
}

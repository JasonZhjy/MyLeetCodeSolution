package algorithm;

import java.util.Arrays;

public class UniquePaths {
    /**
     * paths{m, n} = paths{m - 1, n} + paths{m, n - 1}
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] tab = new int[n][m];
        // init
        Arrays.fill(tab[0], 1);
        for (int i = 1; i < n; i++) {
            tab[i][0] = 1;
        }

        // compute
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                tab[i][j] = tab[i - 1][j] + tab[i][j - 1];
            }
        }

        return tab[n - 1][m - 1];
    }

    public static void main(String[] args) {
        UniquePaths test = new UniquePaths();
        System.out.println(test.uniquePaths(3, 2));
    }
}

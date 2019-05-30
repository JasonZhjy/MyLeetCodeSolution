package algorithm;

/**
 * 174. LeetCode 地下城游戏
 */
public class 地下城游戏 {

    int[] rl = {1, 0};
    int[] cl = {0, 1};
    public int calculateMinimumHP (int[][] dungeon) {
        int minKill = run(0, 0, 0, 0, dungeon);

        return minKill >= 0 ? 1 : 0 - minKill + 1;
    }

    public Integer run (int curI, int curJ, int curKill, int maxKill, int[][] dungeon) {
        if (curI >= dungeon[0].length || curJ >= dungeon.length) {
            return null;
        }

        int m = curKill + dungeon[curI][curJ];
        maxKill = Math.min(m, maxKill);
        int nextMax = maxKill;
        for (int i = 0; i < 2; i++) {
            Integer kill = run(curI + rl[i], curJ + cl[i], m, maxKill, dungeon);
            nextMax = kill != null ? Math.max(nextMax, kill) : nextMax;
        }

        return Math.max(m, nextMax);
    }

    public static void main (String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};

        地下城游戏 test = new 地下城游戏();
        System.out.println(test.calculateMinimumHP(dungeon));
    }
}

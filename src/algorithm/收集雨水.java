package algorithm;

import java.util.Stack;

/**
 * 42. Trapping Rain Water 收集雨水
 */
public class 收集雨水 {
    public int trap (int[] height) {
        Stack<Integer> stack = new Stack<>();

        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                if (stack.isEmpty()) continue;
                res += (Math.min(height[stack.peek()], height[i]) - height[t]) * (i - stack.peek() - 1);
            }
        }

        return res;
    }

    /**
     * 需要left和right两个指针分别指向数组的首尾位置，从两边向中间扫描，
     * 在当前两指针确定的范围内，先比较两头找出较小值，如果较小值是left指向的值，则从左向右扫描，
     * 如果较小值是right指向的值，则从右向左扫描，若遇到的值比当较小值小，则将差值存入结果，
     * 如遇到的值大，则重新确定新的窗口范围，以此类推直至left和right指针重合
     *
     * @param height
     * @return
     */
    public int trap2 (int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int mn = Math.min(height[l], height[r]);
            if (height[l] == mn) {
                l++;
                while (l < r && height[l] < mn) {
                    res += mn - height[l++];
                }
            } else {
                r--;
                while (l < r && height[r] < mn) {
                    res += mn - height[r--];
                }
            }
        }
        return res;
    }

    /**
     * 解法2的优化
     *
     * @param height
     * @return
     */
    public int trap2_1 (int[] height) {
        int res = 0, l = 0, r = height.length - 1, level = 0;
        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            res += level - lower;
        }
        return res;
    }

    /**
     * DP.
     * 我们维护一个一维的dp数组，这个DP算法需要遍历两遍数组，
     * 第一遍遍历dp[i]中存入i位置左边的最大值，然后开始第二遍遍历数组，
     * 第二次遍历时找右边最大值，然后和左边最大值比较取其中的较小值，
     * 然后跟当前值A[i]相比，如果大于当前值，则将差值存入结果
     *
     * @param height
     * @return
     */
    public int trap3 (int[] height) {
        int[] dp = new int[height.length];
        int max = 0, res = 0;
        for (int i = 0; i < height.length; i++) {
            dp[i] = max;
            max = Math.max(height[i], max);
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            dp[i] = Math.min(dp[i], max);
            max = Math.max(height[i], max);

            if (dp[i] - height[i] > 0) {
                res += dp[i] - height[i];
            }
        }

        return res;
    }
}

package 程序员代码面试指南;

import java.util.Arrays;
import java.util.Stack;

public class 求最大子矩阵大小 {

    public int maxRecSize (int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxAera = 0;
        int[] height = new int[map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxAera = Math.max(maxRecFromBottom(height), maxAera);
        }

        return maxAera;
    }

    public int maxRecFromBottom (int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int curArea = height[j] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int curArea = height[j] * (stack.isEmpty() ? height.length : (height.length - stack.peek() - 1));
            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }

    public int maxRecFromBottom_2 (int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0, i = 0;
        int[] h = Arrays.copyOf(height, height.length + 1);
        h[h.length + 1] = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int k = stack.pop();
                maxArea = Math.max(maxArea, h[k] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
        }

        return maxArea;
    }

}

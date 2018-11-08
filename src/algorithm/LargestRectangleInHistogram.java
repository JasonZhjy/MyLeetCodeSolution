package algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * 84.
 * <p>
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * 示意图不对，代码正确
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea (int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, i = 0;
        int[] h = Arrays.copyOf(heights, heights.length + 1);
        h[h.length - 1] = 0;
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int k = stack.pop();
                max = Math.max(max, h[k] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return max;
    }

    public static void main (String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        System.out.println(test.largestRectangleArea(nums));
    }
}

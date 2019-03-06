package myTestCode;

import java.util.Arrays;
import java.util.Stack;

public class DailyCode {
    public String longestPalindrome (String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int maxLen = 0;
        String maxStr = null;
        for (int idx = 0; idx < s.length(); idx++) {
            int i = 1;
            int subLen = 1;
            while (idx - i >= 0 && idx + i < s.length() && s.charAt(idx - i) == s.charAt(idx + i)) {
                subLen += 2;
                i++;
            }
            maxStr = subLen > maxLen ? s.substring(idx - i + 1, idx + i) : maxStr;
            maxLen = Math.max(maxLen, subLen);

            if (idx + 1 < s.length() && s.charAt(idx) == s.charAt(idx + 1)) {
                subLen = 2;
                i = 1;
                while (idx - i >= 0 && idx + 1 + i < s.length() && s.charAt(idx - i) == s.charAt(idx + 1 + i)) {
                    subLen += 2;
                    i++;
                }

                maxStr = subLen > maxLen ? s.substring(idx - i + 1, idx + 1 + i) : maxStr;
                maxLen = Math.max(maxLen, subLen);
            }
        }

        return maxStr;
    }

    public boolean isValid (String s) {
        if ("".equals(s)) {
            return true;
        }
        Stack stack = new Stack();
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
        }

        return false;
    }

    public String countAndSay (int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int key = chars[0] - '0', count = 0;
        for (int i = 0; i < chars.length; i++) {
            int val = chars[i] - '0';
            if (key == val) {
                count++;
            } else {
                sb.append(count + "" + key);
                count = 1;
                key = val;
            }
        }
        sb.append(count + "" + key);

        return sb.toString();
    }

    public int trap (int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                if (stack.isEmpty()) continue;
                res += (Math.min(height[stack.peek()], height[i]) - height[t]) * (i - stack.peek() - 1);
            }
        }

        return res;
    }

    public static void main (String[] args) {
//        String s = "abcba";
//        DailyCode dailyCode = new DailyCode();
//        System.out.println(dailyCode.countAndSay(5));

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(getAndRemoveLastElement(stack));

    }


    public static int getAndRemoveLastElement (Stack<Integer> stack) {
        int ele = stack.pop();
        if (stack.isEmpty()) {
            return ele;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(ele);
            return last;
        }
    }

    public static void reverse (Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }
}

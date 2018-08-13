package algorithm;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        Stack<String> stack = new Stack();
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if ("(".equals(arr[i]) || "[".equals(arr[i]) || "{".equals(arr[i])) {
                stack.push(arr[i]);
            } else if (!stack.isEmpty()) {
                String left = stack.pop();
                if (left == null || !isValid(left, arr[i])) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isValid(String left, String right) {
        if ("(".equals(left) && ")".equals(right)
                || "[".equals(left) && "]".equals(right)
                || "{".equals(left) && "}".equals(right)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.isValid(""));
    }
}

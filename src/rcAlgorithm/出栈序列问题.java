package rcAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 出栈序列问题 {

    /**
     * s为入栈序列，获取所有的出栈序列
     *
     * @param s
     * @return
     */
    public List<String> getAllOutStackList (String s) {
        List<String> rs = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        fun(s, 0, stack, "", rs);
        return rs;
    }

    private void fun (String s, int n, Stack<Character> stack, String sout, List<String> rs) {
        if (n == s.length() && stack.isEmpty()) {
            rs.add(sout);
        } else {
            Stack<Character> s1 = (Stack<Character>) stack.clone();
            Stack<Character> s2 = (Stack<Character>) stack.clone();

            //选择入栈
            if (n < s.length()) {   // 未全部入栈
                s1.push(s.charAt(n));
                fun(s, n + 1, s1, sout, rs);
            }
            //选择出栈
            if (!s2.isEmpty()) {
                fun(s, n, s2, sout + s2.pop(), rs);
            }
        }
    }

    /**
     * 检测是否为出栈序列
     * @param s
     * @param b
     * @return
     */
    public boolean isOutStackLink (String s, String b) {
        Stack<Character> stack = new Stack<>();
        char[] inOrder = s.toCharArray();
        char[] outOrder = b.toCharArray();
        int idx = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (!stack.isEmpty() && stack.peek() == outOrder[idx]) {
                stack.pop();
                idx++;
            }
            stack.push(inOrder[i]);
        }

        while (!stack.isEmpty() && stack.peek() == outOrder[idx]) {
            idx++;
            stack.pop();
        }

        return idx == outOrder.length;
    }

    public static void main (String[] args) {
        出栈序列问题 test = new 出栈序列问题();
        List<String> rs = test.getAllOutStackList("123");
        rs.forEach(System.out::println);
    }
}

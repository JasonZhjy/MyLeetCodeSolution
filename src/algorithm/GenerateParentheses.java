package algorithm;

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        Set<String> rs = new HashSet<>();
        if (n == 0) {
            rs.add("");
        } else {
            List<String> pre = generateParenthesis(n - 1);
            pre.forEach(str -> {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = str.substring(0, i + 1) + "()"
                                + str.substring(i + 1);
                        rs.add(s);
                    }
                }
                rs.add(str + "()");
            });
        }

        return new ArrayList<>(rs);
    }

    public static void main(String[] args) {
        GenerateParentheses test = new GenerateParentheses();
        int n = 3;
        List<String> rs = test.generateParenthesis(n);
        rs.forEach(System.out::println);
    }
}

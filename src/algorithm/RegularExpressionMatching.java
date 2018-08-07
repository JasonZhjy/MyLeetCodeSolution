package algorithm;

import java.util.Arrays;

/**
 * 10. Regular Expression Matching
 * 不会做， 看答案看的勉强理解
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (p.length() == 1) {
            return (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        }
        if (p.charAt(1) != '*') {
            if (s.isEmpty()) return false;
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) return true;
            s = s.substring(1);
        }

        return isMatch(s, p.substring(2));
    }


    /**
     * DP, made  看的我头疼
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_DP(String s, String p) {
        int m = s.length(), n = p.length();
        //m+1行, n+1列
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化第0列，除了[0][0]为true，其他全为false, 因为只有空串S才能匹配空串P.
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        dp[0][0] = true;
        // 初始化第0列(S为"")，只有X*能匹配空串，如果有*，他的值一定和p[0][j - 2]的相同(认为他匹配空串)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j > 1 && '*' == p.charAt(j - 1) && dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2]     //匹配0个
                            || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]; //匹配一个或多个(匹配1个也是从匹配0个推出来的)
                } else {
                    dp[i][j] = (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) && dp[i - 1][j - 1];
                }
            }
        }

        for (int k = 0; k <= m; k++) {
            System.out.println(Arrays.toString(dp[k]));
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching test = new RegularExpressionMatching();
        String s = "ssissippi";
        String p = "s*is*ip*.";
        System.out.println(test.isMatch_DP(s, p));
    }
}

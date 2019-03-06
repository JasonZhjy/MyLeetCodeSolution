package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 131
 * <p>
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class 分割回文串 {

    public List<List<String>> partition (String s) {
        List<List<String>> rs = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return null;
        }

        dfs(rs, new ArrayList<>(), s, 0);

        return rs;
    }

    public void dfs (List<List<String>> rs, List<String> list, String s, int k) {
        if (k == s.length() - 1) {
            rs.add(list);
            return;
        }

        for (int i = 1; i < s.length() - k; i++) {
            String str = s.substring(k, i);
            if (isPali(str)) {
                List<String> listCopy = new ArrayList<>(list);
                listCopy.add(str);
                dfs(rs, listCopy, s, k + i);
            }
        }
    }

    public boolean isPali (String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i)) return false;
        }
        return true;
    }

    public static void main (String[] args) {
        String s = "asd";
        System.out.println(s.substring(0, 0));
    }
}

package algorithm;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        final String dict[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "qps", "tuv", "wxyz"};
        List<String> rs = new ArrayList<>();

        if (!"".equals(digits)) {
            dfs("", 0, digits, dict, rs);
        }

        return rs;
    }

    private void dfs(String str, int idx, String digits, String[] dict, List<String> rs) {
        if (idx == digits.length()) {
            return;
        }
        int n;
        //<editor-fold desc="validation">
        if ((n = digits.charAt(idx) - '0') < 0 || n > 9) {
            return;
        }
        //</editor-fold>
        String val = dict[n];
        String[] vals = val.split("");
        for (String s : vals) {
            dfs(str + s, idx + 1, digits, dict, rs);
        }
    }


    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
        List<String> rs = test.letterCombinations("");
        System.out.println(Arrays.toString(rs.toArray()));
    }
}

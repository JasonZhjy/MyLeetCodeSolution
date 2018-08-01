package algorithm;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0 || s.length() == 1) {
            return s;
        }

        String maxSub = "";
        for (int i = 0; i < s.length(); i++) {
            int subMax1, subMax2 = 0, idx1, idx2 = 0;
            String subMaxStr;
            // 1. 以该字符为中心
            idx1 = getMaxSubNum(s, i, i);
            subMax1 = 2 * idx1 + 1;

            //2. 以该字符和下一个字符为中心
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                idx2 = getMaxSubNum(s, i, i + 1);
                subMax2 = 2 * idx2 + 2;
            }

            if (subMax1 > subMax2) {
                subMaxStr = s.substring(i - idx1, i + idx1 + 1);
            } else {
                subMaxStr = s.substring(i - idx2, i + 1 + idx2 + 1);
            }

            if (maxSub.length() < subMaxStr.length()) {
                maxSub = subMaxStr;
            }
        }

        return maxSub;
    }

    public int getMaxSubNum(String s, int low, int high) {
        int subMax = 0;
        while (low - 1 >= 0 && high + 1 < s.length() && s.charAt(low - 1) == s.charAt(high + 1)) {
            --low;
            ++high;
            ++subMax;
        }
        return subMax;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("a"));
    }

}

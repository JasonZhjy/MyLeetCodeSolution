package algorithm;

//3. Longest Substring Without Repeating Characters
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s) || s == null) return 0;
        int left = 0, right = 0, maxLen = 1, len = 1;
        while (right++ < s.length() - 1) {
            String str = s.substring(left, right);
            int index;
            if ((index = str.lastIndexOf(s.charAt(right) + "")) > -1) {
                len = right - (index + left);
                left += index;
            } else {
                len++;
            }
            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstring test = new LongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("abcade"));
    }

}

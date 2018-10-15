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
                left += index + 1;
            } else {
                len++;
            }
            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        if ("".equals(s) || s == null) return 0;
        int left = 0, right = 0, maxLen = 1, len = 0;
        while (right++ < s.length() - 1) {
            String str = s.substring(left, right);
            int index;
            if ((index = str.lastIndexOf(s.charAt(right) + "")) > -1) {
                len = str.length();
                left = left + index + 1;
            } else {
                len = right - left + 1;
            }
            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        LongestSubstring test = new LongestSubstring();
        System.out.println(test.lengthOfLongestSubstring2("pwwkew"));
    }

}

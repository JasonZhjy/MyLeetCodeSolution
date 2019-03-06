package algorithm;

/**
 * LeetCode 125
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class 验证回文串 {
    public boolean isPalindrome (String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(chars[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(chars[j])) {
                j--;
            } else if (Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[j])) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

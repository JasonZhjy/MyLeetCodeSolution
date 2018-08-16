package algorithm;

/**
 * 28. Implement strStr()
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int idx = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else if (j == needle.length() - 1) {
                    idx = i;
                    return idx;
                }
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ello";
        ImplementStrStr test = new ImplementStrStr();

        System.out.println(test.strStr(haystack, needle));
    }
}

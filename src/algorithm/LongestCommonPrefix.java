package algorithm;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String s = "";
        for (int i = 0; i <= strs[0].length(); i++) {
            s = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(s)) {
                    return s.substring(0, s.length() - 1);
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = {"d"};
        System.out.println(test.longestCommonPrefix(strs));
    }
}

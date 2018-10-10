package rcAlgorithm;

/**
 * KMP算法
 */
public class KMP {


    private static int[] getNext (String s) {
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i < s.length()) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }
}

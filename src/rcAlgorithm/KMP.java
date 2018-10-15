package rcAlgorithm;

/**
 * KMP算法
 */
public class KMP {

    private static int KMP (String s1, String s2) {
        int i = 0, j = 0;
        int[] next = getNext(s2);

        while (i < s1.length() && j < s2.length()) {
            if (j == -1 || s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == s2.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] getNext (String s) {
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < s.length()) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
//                i++;
//                j++;
//                next[i] = j;
                next[i++] = j++;
            } else {
                j = next[j];
            }
        }

        return next;
    }

    public static void main (String[] args) {
        String s1 = "barfofoothefoobarman", s2 = "foo";
        System.out.println(KMP.KMP(s1, s2));
    }
}

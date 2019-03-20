package algorithm;

/**
 * LeetCode 191.
 */
public class NumberOf1Bits {
    public int hammingWeight (int n) {
        int rs = 0;
        while (n != 0) {
            rs += n & 1;
            n = n >>> 1;
        }

        return rs;
    }


}

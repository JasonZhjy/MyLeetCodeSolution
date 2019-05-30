package algorithm;

/**
 * 172 LeetCode
 */
public class 阶乘后的零 {
    public int trailingZeroes (int n) {
        int rs = 0;
        while (n > 0) {
            rs += n / 5;
            n /= 5;
        }

        return rs;
    }

    public static void main (String[] args) {
        阶乘后的零 test = new 阶乘后的零();

        System.out.println(test.trailingZeroes(25));
    }
}

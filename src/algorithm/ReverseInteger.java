package algorithm;

public class ReverseInteger {
    public int reverse(int x) {
        Long rs = 0L;
        while (x != 0) {
            rs = 10 * rs + x % 10;
            x /= 10;
        }
        return (rs < Integer.MIN_VALUE || rs > Integer.MAX_VALUE) ? 0 : rs.intValue();
    }

    public int reverse_solution2(int x) {
        int rs = 0;
        while (x != 0) {
            int t = rs * 10 + x % 10;
            if (t / 10 != rs) return 0;
            rs = t;
            x = x / 10;
        }
        return rs;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse_solution2(-11));
    }

}

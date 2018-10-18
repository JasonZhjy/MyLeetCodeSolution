package algorithm;

/**
 * 29. 两数相除
 */
public class 两数相除 {
    public int divide (int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        boolean lt0 = a == dividend ^ b == divisor;

        int count, num = 0;
        long sum;
        while (b <= a) {
            sum = b;
            count = 1;
            while (sum + sum <= a) {
                sum += sum;
                count += count;
            }
            a = a - sum;
            num = num + count;
        }

        if (lt0) num = -num;
        return num;
    }

    public static void main (String[] args) {
        两数相除 test = new 两数相除();
        System.out.println(test.divide(Integer.MIN_VALUE, 1));
    }

}

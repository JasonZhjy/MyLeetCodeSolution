package rcAlgorithm;

/**
 * 题目：丑数
 * * 我们把只包含因子2，3，5的数称为丑数（Ugly Number).
 * * 求按从小到大的顺序的第1500个丑数。
 * * 例如6，8都是丑数，但14不是，因为它含有因子7.习惯上我们把1当作第一个丑数
 */
public class 第n个丑数 {

    public int getNglyNumber (int n) {
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int mutiply2 = 0, mutiply3 = 0, mutiply5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(uglyNumber[mutiply2] * 2,
                    Math.min(uglyNumber[mutiply3] * 3, uglyNumber[mutiply5] * 5));
            uglyNumber[i] = min;
            while (mutiply2 * 2 == min) {
                mutiply2++;
            }
            while (mutiply3 * 3 == min) {
                mutiply3++;
            }
            while (mutiply5 * 5 == min) {
                mutiply5++;
            }
        }

        return uglyNumber[n - 1];
    }

    public static void main (String[] args) {
        第n个丑数 test = new 第n个丑数();
        System.out.println(test.getNglyNumber(2));
    }
}

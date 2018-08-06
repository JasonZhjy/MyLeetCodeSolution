package algorithm;

public class ClimbingStairs {
    /**
     * DP solution
     * nums{n} = nums{n - 1} + nums{n - 2}
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int nums = 0;   //nums{n - 1}
        int b1 = 0;     //nums{n - 2}
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                nums = 1;
            } else if (i == 2) {
                b1 = 1;
                nums = 2;
            } else {
                int b2 = b1;
                b1 = nums;
                nums += b2;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        ClimbingStairs test = new ClimbingStairs();
        System.out.println(test.climbStairs(4));
    }
}

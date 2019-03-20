package algorithm;

/**
 * LeetCode 198.
 */
public class HouseRobber {

    /**
     * dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
     *
     * @param nums
     * @return
     */
    public int rob (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int preMax = 0, prepreMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preMax < prepreMax + nums[i]) {
                max = prepreMax + nums[i];
            } else {
                max = preMax;
            }
            prepreMax = preMax;
            preMax = max;
        }

        return max;
    }

    public static void main (String[] args) {
        HouseRobber robber = new HouseRobber();
        int[] nums = {1, 2, 3, 1};
        System.out.println(robber.rob(nums));
    }
}
